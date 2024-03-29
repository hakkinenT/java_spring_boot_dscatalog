package com.hakkinenT.dscatalog.services;

import com.hakkinenT.dscatalog.dto.CategoryDTO;
import com.hakkinenT.dscatalog.dto.ProductDTO;
import com.hakkinenT.dscatalog.entities.Category;
import com.hakkinenT.dscatalog.entities.Product;
import com.hakkinenT.dscatalog.projections.ProductProjection;
import com.hakkinenT.dscatalog.repositories.CategoryRepository;
import com.hakkinenT.dscatalog.repositories.ProductRepository;
import com.hakkinenT.dscatalog.services.exceptions.DatabaseException;
import com.hakkinenT.dscatalog.services.exceptions.ResourceNotFoundException;
import com.hakkinenT.dscatalog.util.Utils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> new ProductDTO(product));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new ProductDTO(product, product.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product product = new Product();
        copyDtoToEntity(dto, product);
        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        try{
            Product product = productRepository.getReferenceById(id);
            copyDtoToEntity(dto, product);
            product = productRepository.save(product);
            return new ProductDTO(product);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try{
            productRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de Integridade!");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity.getCategories().clear();
        for(CategoryDTO categoryDTO : dto.getCategories()){
            Category category = categoryRepository.getReferenceById(categoryDTO.getId());
            entity.getCategories().add(category);
        }

    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(String name, String categoryId, Pageable pageable) {
        List<Long> categoryIds = List.of();
        String emptyList = "0";

        if (!emptyList.equals(categoryId)){
            String[] vet =  categoryId.split(",");
            List<String> list = Arrays.asList(vet);
            categoryIds = list.stream().map(Long::parseLong).toList();
        }


        Page<ProductProjection> page = productRepository.searchProducts(categoryIds, name, pageable);
        List<Long> productIds = page.map(ProductProjection::getId).toList();

        List<Product> entities = productRepository.searchProductsWithCategories(productIds);
        entities = (List<Product>) Utils.replace(page.getContent(), entities);

        List<ProductDTO> dtos = entities.stream().map(p -> new ProductDTO(p, p.getCategories())).toList();

        return new PageImpl<>(dtos, page.getPageable(), page.getTotalElements());
    }
}
