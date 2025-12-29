package com.ecommerce.testprojetecommerce.repository;

import com.ecommerce.testprojetecommerce.domain.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
}
