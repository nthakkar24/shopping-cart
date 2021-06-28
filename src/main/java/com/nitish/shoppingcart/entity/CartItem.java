package com.nitish.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "qty")
    private int quantity;
}
