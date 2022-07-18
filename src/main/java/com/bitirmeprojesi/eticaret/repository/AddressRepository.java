package com.bitirmeprojesi.eticaret.repository;

import com.bitirmeprojesi.eticaret.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<UserAddress,Long> {


}
