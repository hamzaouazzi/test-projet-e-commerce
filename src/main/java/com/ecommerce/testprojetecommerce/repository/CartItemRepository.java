package com.ecommerce.testprojetecommerce.repository;

import com.ecommerce.testprojetecommerce.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByPanierId(Long panierId);
}
