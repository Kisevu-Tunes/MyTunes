package com.ameda.works.auth_service.service.keycloak;


import com.ameda.works.auth_service.dto.UserRegistrationRecord;
import org.keycloak.representations.idm.UserRepresentation;

public interface KeycloakUserService {

    UserRegistrationRecord createUser(UserRegistrationRecord userRegistrationRecord);
    UserRepresentation getUserById(String userId);
    void deleteUserById(String userId);
    void emailVerification(String userId);
    void forgotPassword(String username);
}

