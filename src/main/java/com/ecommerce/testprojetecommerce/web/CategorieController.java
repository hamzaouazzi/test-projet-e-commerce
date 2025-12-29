package com.ecommerce.testprojetecommerce.web;

import com.ecommerce.testprojetecommerce.domain.Categorie;
import com.ecommerce.testprojetecommerce.service.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping
    public ResponseEntity<Categorie> create(@RequestBody Categorie dto,
                                            @RequestParam(required = false) Long parentId) {
        return ResponseEntity.ok(categorieService.creerCategorie(dto, parentId));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update(@PathVariable Long id,
                                            @RequestBody Categorie dto) {
        return ResponseEntity.ok(categorieService.modifierCategorie(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categorieService.supprimerCategorie(id);
        return ResponseEntity.noContent().build();
    }
}

