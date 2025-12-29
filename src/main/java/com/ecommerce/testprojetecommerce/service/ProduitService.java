package com.ecommerce.testprojetecommerce.service;

import com.ecommerce.testprojetecommerce.domain.Categorie;
import com.ecommerce.testprojetecommerce.domain.Produit;
import com.ecommerce.testprojetecommerce.repository.CategorieRepository;
import com.ecommerce.testprojetecommerce.repository.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    public ProduitService(ProduitRepository produitRepository,
                          CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }

    public Produit creerProduit(Produit p, Long categorieId) {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new IllegalArgumentException("Catégorie introuvable"));
        p.setCategorie(categorie);
        return produitRepository.save(p);
    }

    public Produit modifierProduit(Long id, Produit maj) {
        Produit existant = produitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produit introuvable"));
        existant.setNom(maj.getNom());
        existant.setPrix(maj.getPrix());
        existant.setStock(maj.getStock());
        return produitRepository.save(existant);
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }

    public Produit changerCategorie(Long produitId, Long categorieId) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new IllegalArgumentException("Produit introuvable"));
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new IllegalArgumentException("Catégorie introuvable"));
        produit.setCategorie(categorie);
        return produitRepository.save(produit);
    }

    public Produit retirerDeCategorie(Long produitId) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new IllegalArgumentException("Produit introuvable"));
        produit.setCategorie(null);
        return produitRepository.save(produit);
    }
}

