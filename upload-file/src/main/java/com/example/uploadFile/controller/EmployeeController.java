package com.example.uploadFile.controller;

import com.example.uploadFile.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {
    private static final String PHOTO_DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    List<Employee> list = new ArrayList<>();

    @PostMapping("/addEmp")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        list.add(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return list.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return list;
    }

    @PutMapping("/photo")
    public String uploadPhoto(@RequestParam("id") Long id, @RequestParam("file") MultipartFile file) {
        log.info("Saving photo for user ID: {}", id);
        Employee employee = getEmployee(id);
        String photoURL = photoFunction.apply(id, file);
        employee.setPhotoURL(photoURL);
        return "Uploaded sucessfully";
    }

    private final Function<String, String> fileExtension = fileName -> {
        return Optional.of(fileName)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(fileName.lastIndexOf(".") + 1))
                .orElse("png");
    };
    private final BiFunction<Long, MultipartFile, String> photoFunction = (id, image) -> {
        String fileName = id + fileExtension.apply(image.getOriginalFilename());
        try {
            Path fileStorageLocation = Paths.get(PHOTO_DIRECTORY).toAbsolutePath().normalize();
            if(!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(image.getInputStream(), fileStorageLocation, REPLACE_EXISTING);
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/users/image" + id + fileExtension.apply(image.getOriginalFilename())).toUriString();
        } catch(Exception e) {
            throw new RuntimeException("Unable to save image");
        }
    };
}
