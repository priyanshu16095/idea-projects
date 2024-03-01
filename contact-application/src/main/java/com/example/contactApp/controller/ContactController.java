package com.example.contactApp.controller;

import com.example.contactApp.entity.Contact;
import com.example.contactApp.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    private final String PHOTO_DIRECTORY = "C:\\Users\\navra\\Downloads\\app-api\\src\\main\\resources\\static";

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Contact contact = contactService.getContact(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @GetMapping("/allContacts")
    public ResponseEntity<Page<Contact>> getContacts(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(contactService.getAllContacts(page, size));
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        URI location = URI.create("contact" + contact.getId());
        return ResponseEntity.created(location).body(contactService.createContact(contact));
    }
    @PutMapping("/update")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        URI location = URI.create("contact" + contact.getId());
        return ResponseEntity.created(location).body(contactService.updateContact(contact));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> getContactsCount() {
        return new ResponseEntity<>(contactService.totalContacts(), HttpStatus.OK);
    }

    @PutMapping(path = "/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("id") Long id, @RequestParam("file")MultipartFile file) {
        String photoURL = contactService.uploadPhoto(id, file);
        return new ResponseEntity<>(photoURL, HttpStatus.OK);
    }
    @GetMapping(path = "/image/{filename}", produces = {IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE})
    public byte[] getImage(@PathVariable String filename) throws IOException {
        Path fileLocation = Paths.get(PHOTO_DIRECTORY + "/" + filename);
        return Files.readAllBytes(fileLocation);
    }
}
