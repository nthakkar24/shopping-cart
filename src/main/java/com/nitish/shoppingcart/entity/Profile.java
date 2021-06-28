package com.nitish.shoppingcart.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dps_profile")
@Getter
@Setter
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private String id;

    private String name;

    private String email;

    @Column(name = "pwd")
    private String password;
}
