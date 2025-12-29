package com.ecommerce.testprojetecommerce.repository;

import com.ecommerce.testprojetecommerce.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findByParentIsNull();
}
