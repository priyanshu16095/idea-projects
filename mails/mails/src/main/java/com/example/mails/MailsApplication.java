package com.example.mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailsApplication.class, args);
	}

	@Autowired
	private EmailSenderService emailSenderService;

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {
		emailSenderService.sendMail("2023359463.priyanshu@ug.sharda.ac.in",
				"This is a test mail, sended by my spring application.",
				"Test Mail");
	}

}
