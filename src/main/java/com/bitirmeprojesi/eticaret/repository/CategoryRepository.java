package com.bitirmeprojesi.eticaret.repository;

import com.bitirmeprojesi.eticaret.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory,Long> {

    ProductCategory findByName(String categoryname);

}
