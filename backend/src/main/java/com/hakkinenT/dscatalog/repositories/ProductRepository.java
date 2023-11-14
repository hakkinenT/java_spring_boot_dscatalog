package com.hakkinenT.dscatalog.repositories;

import com.hakkinenT.dscatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
