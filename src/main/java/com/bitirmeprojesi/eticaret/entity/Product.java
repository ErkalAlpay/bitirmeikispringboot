package com.bitirmeprojesi.eticaret.entity;


import com.bitirmeprojesi.eticaret.base.BaseEntity;
import jdk.jfr.Category;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne(optional = false)
    private ProductCategory product_category;
    @Column
    private String image_url;

    @OneToOne
    private ProductInventory product_inventory;

    @ManyToOne
    private Discount discount;


}
