package com.example.roughapipractice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdAt;

    private String token;

    @OneToOne(targetEntity = Contact.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Confirmation(Contact contact) {
        this.contact = contact;
        this.createdAt = LocalDateTime.now();
        this.token = UUID.randomUUID().toString();
    }
}
