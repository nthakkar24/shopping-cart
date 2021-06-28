package com.nitish.shoppingcart.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dcs_product")
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id")
    private String id;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_short_desc")
    private String description;
}
