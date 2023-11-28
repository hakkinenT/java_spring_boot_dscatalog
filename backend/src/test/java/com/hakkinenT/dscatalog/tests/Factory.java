package com.hakkinenT.dscatalog.tests;

import com.hakkinenT.dscatalog.dto.ProductDTO;
import com.hakkinenT.dscatalog.entities.Category;
import com.hakkinenT.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {
    public static Product createProduct(){
        Product product = new Product(1L, "Phone", "Good Phone", 800.0, "http://img.com/img.png");
        product.getCategories().add(new Category(2L, "Electronics"));
        return product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }

    public static ProductDTO createProductDTOToInsert(){
        Product product = createProduct();
        product.setId(null);
        return new ProductDTO(product, product.getCategories());
    }
}
