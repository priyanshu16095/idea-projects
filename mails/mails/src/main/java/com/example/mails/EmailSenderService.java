package com.example.mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String email, String body, String subject) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setText(body);
            message.setSubject(subject);

            javaMailSender.send(message);

            System.out.println("Mail sent successfully to: " + email);
        } catch (Exception e) {
            System.err.println("Error sending email to " + email + ": " + e.getMessage());
        }
    }
}
