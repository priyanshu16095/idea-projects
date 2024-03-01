package com.example.rough.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.example.rough.entity.Employee;
import jakarta.servlet.http.HttpServlet;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/app")
public class EmployeeController {
    private String PHOTO_DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    List<Employee> list = new ArrayList<>();

    @PostMapping("/addEmp")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        list.add(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(list.indexOf(employee))
                .toUri();
        return ResponseEntity.created(location).body(employee);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        for(Employee emp : list) {
            if(emp.getId() == id) {
                return new ResponseEntity<>(emp, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/emp/uploadPhoto")
    public ResponseEntity<String> uploadPhoto(@RequestParam("id") Long id, @RequestParam("file")MultipartFile file) {
        Employee emp = getEmployee(id).getBody();
        String photoURL = photoFunction.apply(id, file);
        emp.setPhotoURL(photoURL);
        return new ResponseEntity<>("Uploaded sucessfully", HttpStatus.CREATED);
    }
    @GetMapping(path = "/image/{filename}", produces = {IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE})
    public byte[] getPhoto(@PathVariable("filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(PHOTO_DIRECTORY + filename));
    }

    private final Function<String, String> fileExtension = filename -> {
        return Optional.of(filename)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(filename.lastIndexOf(".") + 1))
                .orElse("png");
    };
    private final BiFunction<Long, MultipartFile, String> photoFunction = (id, file) -> {
        String filename = "emp" + id + "." + fileExtension.apply(file.getOriginalFilename());
        Path fileStorageLocation = Paths.get(PHOTO_DIRECTORY);
        try {
            if(!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(file.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING);
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("emp/photos/" + filename)
                    .toUriString();
        } catch(Exception e) {
            throw new RuntimeException("Unable to save image");
        }
    };
}
