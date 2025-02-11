package com.ameda.works.auth_service.controller;

import com.ameda.works.auth_service.dto.UserRegistrationRecord;
import com.ameda.works.auth_service.service.keycloak.KeycloakUserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class KeycloakUserApi {


    private final KeycloakUserService keycloakUserService;

    public KeycloakUserApi(KeycloakUserService keycloakUserService) {
        this.keycloakUserService = keycloakUserService;
    }


    @PostMapping
    public UserRegistrationRecord createUser(
            @RequestBody UserRegistrationRecord userRegistrationRecord) {

        return keycloakUserService.createUser(userRegistrationRecord);
    }

    @GetMapping
    public UserRepresentation getUser(Principal principal) {

        return keycloakUserService.getUserById(principal.getName());
    }

    @GetMapping("/{userId}")
    public UserRepresentation getUserById(@PathVariable String userId) {

        return keycloakUserService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        keycloakUserService.deleteUserById(userId);
    }


    @PutMapping("/{userId}/send-verify-email")
    public void sendVerificationEmail(@PathVariable String userId) {
        keycloakUserService.emailVerification(userId);
    }
}

