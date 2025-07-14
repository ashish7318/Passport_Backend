package com.Passport.Passports.service;

import com.Passport.Passports.model.PassportApplication;
import com.Passport.Passports.repository.PassportApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportApplicationService {

    private final PassportApplicationRepository repository;

    @Autowired
    public PassportApplicationService(PassportApplicationRepository repository) {
        this.repository = repository;
    }

    // Save or update a passport application
    public PassportApplication save(PassportApplication application) {
        return repository.save(application);
    }

    // Find all passport applications
    public List<PassportApplication> findAll() {
        return repository.findAll();
    }

    // Find one application by ID
    public Optional<PassportApplication> findById(String id) {
        return repository.findById(id);
    }

    // Delete an application by ID
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
