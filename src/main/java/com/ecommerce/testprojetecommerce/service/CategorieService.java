package com.ecommerce.testprojetecommerce.service;

import com.ecommerce.testprojetecommerce.domain.Categorie;
import com.ecommerce.testprojetecommerce.repository.CategorieRepository;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie creerCategorie(Categorie c, Long parentId) {
        if (parentId != null) {
            Categorie parent = categorieRepository
                    .findById(parentId)
                    .orElseThrow(() -> new IllegalArgumentException("Parent introuvable"));
            c.setParent(parent);
        }
        return categorieRepository.save(c);
    }

    public Categorie modifierCategorie(Long id, Categorie maj) {
        Categorie existante = categorieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Catégorie introuvable"));
        existante.setNom(maj.getNom());
        existante.setDescription(maj.getDescription());
        return categorieRepository.save(existante);
    }

    public void supprimerCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}

