package com.Passport.Passports.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passportApplications")
public class PassportApplication {

    @Id
    private String id;

    private String name;
    private String dob; // Can use LocalDate for better type safety
    private String email;
    private String address;
    private String gender;
    private String citizenshipNumber;
    private String passportType;
    private String photoUrl;

    // No-arg constructor
    public PassportApplication() {}

    // All-args constructor (optional)
    public PassportApplication(String name, String dob, String email, String address,
                               String gender, String citizenshipNumber,
                               String passportType, String photoUrl) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.citizenshipNumber = citizenshipNumber;
        this.passportType = passportType;
        this.photoUrl = photoUrl;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public void setCitizenshipNumber(String citizenshipNumber) {
        this.citizenshipNumber = citizenshipNumber;
    }

    public String getPassportType() {
        return passportType;
    }

    public void setPassportType(String passportType) {
        this.passportType = passportType;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "PassportApplication{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", citizenshipNumber='" + citizenshipNumber + '\'' +
                ", passportType='" + passportType + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
