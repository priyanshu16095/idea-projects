package com.example.contactApp.service;


import com.example.contactApp.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ContactService {
    Contact getContact(Long id);
    Page<Contact> getAllContacts(int page, int size);
    Contact createContact(Contact contact);
    Contact updateContact(Contact contact);
    String deleteContact(Long id);
    Integer totalContacts();
    String uploadPhoto(Long id, MultipartFile file);
}
