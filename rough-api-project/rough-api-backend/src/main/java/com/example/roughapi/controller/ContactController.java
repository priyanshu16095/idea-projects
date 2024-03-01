package com.example.roughapi.controller;

import com.example.roughapi.entity.Contact;
import com.example.roughapi.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
    private final String PHOTO_DIRECTORY = "C:\\Users\\navra\\Downloads\\rough-api\\src\\main\\resources\\static";

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Contact contact = contactService.getContact(id);
        if(contact == null) {
            throw new RuntimeException("CONTACT NOT FOUND");
        }
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @GetMapping("/contacts")
    public ResponseEntity<Page<Contact>> getAllContacts(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "10") int size) {
        return new ResponseEntity<>(contactService.getAllContacts(page, size), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        contactService.createContact(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        contactService.updateContact(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePhoto(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/uploadPhoto")
    public ResponseEntity<String> uploadPhoto(@RequestParam("id") Long id,
                                              @RequestParam("file") MultipartFile file) {
        String photoURL = contactService.uploadPhoto(id, file);
        return new ResponseEntity<>(photoURL, HttpStatus.CREATED);
    }
    @GetMapping(path = "/contact/photo/{filename}", produces =  {IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE})
    public byte[] getPhoto(@PathVariable String filename) throws IOException {
        Path fileLocation = Paths.get(PHOTO_DIRECTORY + "/" + filename);
        return Files.readAllBytes(fileLocation);
    }

}
