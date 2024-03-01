package com.example.roughapipractice.service;

import com.example.roughapipractice.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface ContactService {
    Contact getContact(Long id);
    Page<Contact> getAllContacts(int page, int size);
    Contact createContact(Contact contact);
    Contact updateContact(Contact contact);
    String deleteContact(Long id);
    String uploadPhoto(Long id, MultipartFile file);
    byte[] getPhoto(String filename);
    Boolean verifyToken(String token);
}
