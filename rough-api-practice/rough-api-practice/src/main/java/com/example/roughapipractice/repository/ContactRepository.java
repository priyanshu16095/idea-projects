package com.example.roughapipractice.repository;

import com.example.roughapipractice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
