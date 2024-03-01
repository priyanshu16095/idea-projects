package com.example.roughapipractice.repository;

import com.example.roughapipractice.entity.Confirmation;
import com.example.roughapipractice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
    Confirmation findByToken(String token);
}
