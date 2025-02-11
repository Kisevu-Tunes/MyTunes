package com.ameda.works.user_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String id;
    private LocalDate dob;
    private String countryIso2;
    private String type;
    private String storageId;
    @Enumerated(EnumType.STRING)
    private StorageProviders storageProvider;
    private String language;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public StorageProviders getStorageProvider() {
        return storageProvider;
    }

    public void setStorageProvider(StorageProviders storageProvider) {
        this.storageProvider = storageProvider;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", dob=" + dob +
                ", countryIso2='" + countryIso2 + '\'' +
                ", type='" + type + '\'' +
                ", storageId='" + storageId + '\'' +
                ", storageProvider=" + storageProvider +
                ", language='" + language + '\'' +
                '}';
    }
}
