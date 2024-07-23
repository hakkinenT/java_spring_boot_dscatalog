package com.hakkinenT.dscatalog.repositories;

import com.hakkinenT.dscatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
