package com.nitish.shoppingcart.service;

import com.nitish.shoppingcart.bean.Item;
import com.nitish.shoppingcart.entity.CartItem;
import com.nitish.shoppingcart.repository.CartItemRepository;
import com.nitish.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getCartItemsForCustomer(String customerId){
        return cartItemRepository.findByCustomerId(customerId);
    }

    public void addItemToCart(Item item) {
        CartItem cartItem = cartItemRepository.findByProductIdAndCustomerId(item.getProductId(),item.getCustomerId());

        if(null != cartItem){
            cartItem.setQuantity(item.getQuantity() + cartItem.getQuantity());
        }else {
            cartItem = new CartItem();
            cartItem.setCustomerId(item.getCustomerId());
            cartItem.setProductId(item.getProductId());
            cartItem.setQuantity(item.getQuantity());
        }

        cartItemRepository.save(cartItem);
    }

    public void updateQuantity(Item item){
        cartItemRepository.updateQuanity(item.getQuantity(),item.getProductId(),item.getCustomerId());
    }

    public void removeItem(String productId,String customerId){
        cartItemRepository.deleteByCustomerIdAndProductId(customerId,productId);
    }
}
