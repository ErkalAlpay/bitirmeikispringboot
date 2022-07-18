package com.bitirmeprojesi.eticaret.entity;


import com.bitirmeprojesi.eticaret.base.BaseEntity;
import com.bitirmeprojesi.eticaret.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {


    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String telephone;
    @Column(columnDefinition = "boolean default false",nullable = false)
    private Boolean email_status=false;
    @Column(columnDefinition = "boolean default false",nullable = false)
    private Boolean account_block=false;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User(String username, String email, String password, String first_name, String last_name, String telephone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.telephone = telephone;
    }
    public User(String username, String email, String password, String first_name, String last_name, String telephone,Boolean email_status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.email_status=email_status;
    }

    /*@OneToMany
    private List<UserAddress> userAddress=new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "user_payment_id")
    private List<UserPayment> userPayments=new ArrayList<>();*/
}
