package com.ecommerce.testprojetecommerce.web;

import com.ecommerce.testprojetecommerce.domain.Produit;
import com.ecommerce.testprojetecommerce.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public ResponseEntity<Produit> create(@RequestBody Produit dto,
                                          @RequestParam Long categorieId) {
        return ResponseEntity.ok(produitService.creerProduit(dto, categorieId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> update(@PathVariable Long id,
                                          @RequestBody Produit dto) {
        return ResponseEntity.ok(produitService.modifierProduit(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{produitId}/categorie/{categorieId}")
    public ResponseEntity<Produit> affecterCategorie(
            @PathVariable Long produitId,
            @PathVariable Long categorieId) {
        return ResponseEntity.ok(produitService.changerCategorie(produitId, categorieId));
    }

    @DeleteMapping("/{produitId}/categorie")
    public ResponseEntity<Produit> retirerCategorie(@PathVariable Long produitId) {
        return ResponseEntity.ok(produitService.retirerDeCategorie(produitId));
    }
}

