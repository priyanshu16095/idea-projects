package com.example.roughapipractice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    private String address;
    private String photoURL;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private Boolean isEnabled;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
