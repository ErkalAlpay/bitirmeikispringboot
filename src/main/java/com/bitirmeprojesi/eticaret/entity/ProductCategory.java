package com.bitirmeprojesi.eticaret.entity;

import com.bitirmeprojesi.eticaret.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
@Data
public class ProductCategory extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column
    private String description;

}
