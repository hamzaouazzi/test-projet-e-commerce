package com.ecommerce.testprojetecommerce.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "paniers")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
    private List<CartItem> items = new ArrayList<>();

    private Double total = 0.0;

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public List<CartItem> getItems() { return items; }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}

