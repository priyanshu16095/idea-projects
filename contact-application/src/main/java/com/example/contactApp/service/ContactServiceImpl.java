package com.example.contactApp.service;

import com.example.contactApp.entity.Contact;
import com.example.contactApp.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final String PHOTO_DIRECTORY = "C:\\Users\\navra\\Downloads\\app-api\\src\\main\\resources\\static";

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).get();
    }
    @Override
    public Page<Contact> getAllContacts(int page, int size) {
        return contactRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }
    @Override
    public String deleteContact(Long id) {
        contactRepository.deleteById(id);
        return "Deleted";
    }
    @Override
    public Integer totalContacts() {
        return (int) contactRepository.count();
    }

    @Override
    public String uploadPhoto(Long id, MultipartFile file) {
        Contact contact = getContact(id);
        String photoURL = photoFunction.apply(id, file);
        contact.setPhotoURL(photoURL);
        return photoURL;
    }

    private final Function<String, String> fileExtension = filename -> {
        return Optional.of(filename)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(filename.lastIndexOf(".") + 1))
                .orElse("png");
    };
    private final BiFunction<Long, MultipartFile, String> photoFunction = (id, image) -> {
        String filename = "contact-" + id + "." + fileExtension.apply(image.getOriginalFilename());
        try {
            Path fileStorageLocation = Paths.get(PHOTO_DIRECTORY);
            if (!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING);
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/contact/image/" + filename)
                    .build()
                    .toUriString();
        } catch (Exception e) {
            throw new RuntimeException("Unable to save image");
        }
    };
}
