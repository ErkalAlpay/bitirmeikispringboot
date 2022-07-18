package com.bitirmeprojesi.eticaret.repository;

import com.bitirmeprojesi.eticaret.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepsitory extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
