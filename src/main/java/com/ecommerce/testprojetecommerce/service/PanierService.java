package com.ecommerce.testprojetecommerce.service;

import com.ecommerce.testprojetecommerce.domain.CartItem;
import com.ecommerce.testprojetecommerce.domain.Panier;
import com.ecommerce.testprojetecommerce.repository.PanierRepository;
import org.springframework.stereotype.Service;

@Service
public class PanierService {

    private final PanierRepository panierRepository;

    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    public Panier creerPanier() {
        return panierRepository.save(new Panier());
    }

    public Panier ajouterProduit(Long panierId, Long produitId, Integer quantite) {
        Panier panier = panierRepository.findById(panierId).orElseThrow();

        CartItem item = new CartItem();
        item.setProduitId(produitId);
        item.setQuantite(quantite);
        item.setPanier(panier);
        panier.getItems().add(item);
        // on fixe un prix f 10€ temporaire
        panier.setTotal((double) panier.getItems().size() * 10.0);

        return panierRepository.save(panier);
    }
}

