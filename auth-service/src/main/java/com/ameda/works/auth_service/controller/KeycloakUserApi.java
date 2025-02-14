package com.ameda.works.auth_service.controller;

import com.ameda.works.auth_service.dto.UserRegistrationRecord;
import com.ameda.works.auth_service.service.keycloak.KeycloakUserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('LISTENER')")
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

    @PutMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String username){
        keycloakUserService.forgotPassword(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{userId}/assign-role-to-user")
    public ResponseEntity<?> assignRoleToUser(@PathVariable String userId,
                                              @RequestParam String role){
        keycloakUserService.assignRoleToUser(userId, role);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{userId}/un-assign-role-from-user")
    public ResponseEntity<?> unassignRoleFromUser(@PathVariable String userId,
                                                  @RequestParam String role){
        keycloakUserService.deleteRoleFromUser(userId, role);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/roles")
    public ResponseEntity<?> getRoles(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(keycloakUserService.getRoles(id));
    }

    @PutMapping("/{userId}/{groupId}/group")
    public ResponseEntity<?> addToGroup(@PathVariable String userId,
                                        @PathVariable String groupId){
        keycloakUserService.assignToGroup(userId, groupId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{userId}/{groupId}/group")
    public ResponseEntity<?> removeFromGroup(@PathVariable String userId,
                                             @PathVariable String groupId){
        keycloakUserService.removeFromGroup(userId, groupId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

