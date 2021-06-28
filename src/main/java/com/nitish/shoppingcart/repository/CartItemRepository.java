package com.nitish.shoppingcart.repository;

import com.nitish.shoppingcart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,String> {
    List<CartItem> findByCustomerId(String customerId);

    CartItem findByProductIdAndCustomerId(String productId,String customerId);


    @Query("UPDATE CartItem c SET c.quantity = ?1 WHERE productId = ?2 " + "AND customerId =?3")
    @Modifying
    void updateQuanity(Integer qty,String productId,String customerId);


    @Query("DELETE FROM CartItem c where c.customerId = ?1 AND c.productId = ?2")
    @Modifying
    void deleteByCustomerIdAndProductId(String customerId,String productId);
}
