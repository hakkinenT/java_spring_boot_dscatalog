package com.hakkinenT.dscatalog.repositories;

import com.hakkinenT.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
