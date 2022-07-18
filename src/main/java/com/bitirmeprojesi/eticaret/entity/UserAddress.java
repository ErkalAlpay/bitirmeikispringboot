package com.bitirmeprojesi.eticaret.entity;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
@Data
public class UserAddress extends BaseEntity {


    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private User user;
    @Column(nullable = false)
    private String address_line_1;
    @Column
    private String address_line_2;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String telephone;



}
