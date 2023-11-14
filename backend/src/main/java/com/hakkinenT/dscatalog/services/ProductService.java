package com.hakkinenT.dscatalog.services;

import com.hakkinenT.dscatalog.dto.ProductDTO;
import com.hakkinenT.dscatalog.entities.Product;
import com.hakkinenT.dscatalog.repositories.ProductRepository;
import com.hakkinenT.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> new ProductDTO(product));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new ProductDTO(product);
    }


}
