package com.ameda.works.user_service.dto;

import com.ameda.works.user_service.model.StorageProviders;

import java.time.LocalDate;

public class UserDTO {
    private String id;
    private LocalDate dob;
    private String countryIso2;
    private String type;
    private String storageId;
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
        return "UserDTO{" +
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
