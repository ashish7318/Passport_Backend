package com.Passport.Passports.controller;

import com.Passport.Passports.model.PassportApplication;
import com.Passport.Passports.service.PassportApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/passport")
@CrossOrigin(origins = "*")  // Restrict to your React dev server
public class PassportApplicationController {

    @Autowired
    private PassportApplicationService service;

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Passport Application API. Use POST to submit applications.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<PassportApplication>> getAllApplications() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> receiveApplication(
            @RequestParam("name") String name,
            @RequestParam("dob") String dob,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("gender") String gender,
            @RequestParam("citizenshipNumber") String citizenshipNumber,
            @RequestParam("passportType") String passportType,
            @RequestParam(value = "photo", required = false) MultipartFile photo
    ) {
        try {
            String photoUrl = null;

            if (photo != null && !photo.isEmpty()) {
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String originalFilename = photo.getOriginalFilename();
                String safeFilename = System.currentTimeMillis() + "_" +
                        (originalFilename != null ? originalFilename.replaceAll("[^a-zA-Z0-9._-]", "_") : "unknown.jpg");

                Path filePath = uploadPath.resolve(safeFilename);
                Files.write(filePath, photo.getBytes());

                photoUrl = "/uploads/" + safeFilename;
            }

            PassportApplication application = new PassportApplication();
            application.setName(name);
            application.setDob(dob);
            application.setEmail(email);
            application.setAddress(address);
            application.setGender(gender);
            application.setCitizenshipNumber(citizenshipNumber);
            application.setPassportType(passportType);
            application.setPhotoUrl(photoUrl);

            PassportApplication saved = service.save(application);
            return ResponseEntity.ok(saved);

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error saving uploaded file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }
}

