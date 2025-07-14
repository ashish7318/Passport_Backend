package com.Passport.Passports.repository;

import com.Passport.Passports.model.PassportApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportApplicationRepository extends MongoRepository<PassportApplication, String> {
    // Optional: Add custom query methods if needed later
    // List<PassportApplication> findByEmail(String email);
    // List<PassportApplication> findByPassportType(String type);
}
