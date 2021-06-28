package com.nitish.shoppingcart.controller;

import com.nitish.shoppingcart.bean.Item;
import com.nitish.shoppingcart.entity.CartItem;
import com.nitish.shoppingcart.service.CartService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping(path = "/cart/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<CartItem>> showShoppingCart(@Valid @PathVariable @NotNull String customerId){

        List<CartItem> cartItems = cartService.getCartItemsForCustomer(customerId);

        if(null == cartItems || cartItems.isEmpty()){
            cartItems = new ArrayList<>();
        }

        return ResponseEntity.ok(cartItems);
    }

    @PostMapping(path = "/cart", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartItem>> addItemToCart(@Valid @RequestBody Item item){
        cartService.addItemToCart(item);
        List<CartItem> cartItems = cartService.getCartItemsForCustomer(item.getCustomerId());

        return ResponseEntity.status(HttpStatus.CREATED).body(cartItems);
    }

    @PutMapping(path = "/cart", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartItem>> updateCartQuantity(@RequestBody Item item){
        cartService.updateQuantity(item);
        List<CartItem> cartItems = cartService.getCartItemsForCustomer(item.getCustomerId());

        return ResponseEntity.status(HttpStatus.CREATED).body(cartItems);
    }

    @DeleteMapping(path = "/cart/{productId}/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeItem(@NotBlank @PathVariable String productId, @NotBlank @PathVariable String customerId){
        cartService.removeItem(productId,customerId);
        return ResponseEntity.ok().build();
    }
}
