package com.ameda.works.auth_service.dto;

public record UserRegistrationRecord(String username,
                                     String email,
                                     String firstName,
                                     String lastName,
                                     String password,
                                     boolean artist) {
}

