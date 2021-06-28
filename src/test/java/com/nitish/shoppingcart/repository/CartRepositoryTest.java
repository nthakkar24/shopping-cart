package com.nitish.shoppingcart.repository;

import com.nitish.shoppingcart.entity.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CartRepositoryTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Test
    public void testAddItemToCart(){
        CartItem item = new CartItem();
        item.setCustomerId("12345");
        item.setProductId("prod123");
        item.setQuantity(1);
        CartItem savedItem =  cartItemRepository.save(item);
        assertTrue(savedItem.getId() > 0);
    }
}
