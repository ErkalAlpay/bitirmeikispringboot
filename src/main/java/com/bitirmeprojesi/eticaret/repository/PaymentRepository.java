package com.bitirmeprojesi.eticaret.repository;

import com.bitirmeprojesi.eticaret.entity.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<UserPayment,Long> {
}
