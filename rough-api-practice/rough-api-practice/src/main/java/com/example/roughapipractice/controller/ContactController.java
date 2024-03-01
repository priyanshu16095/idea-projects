package com.example.roughapipractice.controller;

import com.example.roughapipractice.entity.Contact;
import com.example.roughapipractice.entity.HttpResponse;
import com.example.roughapipractice.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping("/add")
    public ResponseEntity<HttpResponse> createContact(@RequestBody Contact contact) {
        contactService.createContact(contact);
        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timestamp(LocalDateTime.now().toString())
                        .httpStatus(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Contact created")
                        .enabled(false)
                        .data(Map.of("contact", contact))
                        .build()
        );
    }
}
