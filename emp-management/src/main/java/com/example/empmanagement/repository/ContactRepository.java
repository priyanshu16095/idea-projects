package com.example.empmanagement.repository;

import com.example.empmanagement.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> {
    Optional<Contact> findById(String id);
}
