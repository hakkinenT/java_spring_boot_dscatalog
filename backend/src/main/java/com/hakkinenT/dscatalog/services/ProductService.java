package com.hakkinenT.dscatalog.services;

import com.hakkinenT.dscatalog.dto.ProductDTO;
import com.hakkinenT.dscatalog.entities.Product;
import com.hakkinenT.dscatalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> new ProductDTO(product));
    }
}
