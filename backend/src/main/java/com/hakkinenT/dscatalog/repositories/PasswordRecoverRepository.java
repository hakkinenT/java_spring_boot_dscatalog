package com.hakkinenT.dscatalog.repositories;

import com.hakkinenT.dscatalog.entities.PasswordRecover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRecoverRepository extends JpaRepository<PasswordRecover, Long> {
}
