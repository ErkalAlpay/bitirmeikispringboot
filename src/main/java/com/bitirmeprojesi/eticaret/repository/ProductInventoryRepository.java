package com.bitirmeprojesi.eticaret.repository;

import com.bitirmeprojesi.eticaret.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory,Long> {

}
