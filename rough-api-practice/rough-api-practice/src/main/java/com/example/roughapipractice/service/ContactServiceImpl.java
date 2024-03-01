package com.example.roughapipractice.service;

import com.example.roughapipractice.entity.Confirmation;
import com.example.roughapipractice.entity.Contact;
import com.example.roughapipractice.repository.ConfirmationRepository;
import com.example.roughapipractice.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ConfirmationRepository confirmationRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).get();
    }
    @Override
    public Page<Contact> getAllContacts(int page, int size) {
        return null;
    }

    @Override
    public Contact createContact(Contact contact) {
        String email = contact.getEmail();
        if(contactRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }
        String encodedPassword = passwordEncoder.encode(contact.getPassword());
        contact.setPassword(encodedPassword);
        contact.setIsEnabled(false);
        contactRepository.save(contact);

        Confirmation confirmation = new Confirmation(contact);
        confirmationRepository.save(confirmation);

        return contact;
    }
    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        Contact contact = contactRepository.findByEmailIgnoreCase(confirmation.getContact().getEmail());
        contact.setIsEnabled(true);
        contactRepository.save(contact);
        return Boolean.TRUE;
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public String deleteContact(Long id) {
        return null;
    }

    @Override
    public String uploadPhoto(Long id, MultipartFile file) {
        return null;
    }

    @Override
    public byte[] getPhoto(String filename) {
        return new byte[0];
    }
}
