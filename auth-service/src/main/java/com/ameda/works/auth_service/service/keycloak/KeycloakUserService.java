package com.ameda.works.auth_service.service.keycloak;


import com.ameda.works.auth_service.dto.UserRegistrationRecord;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface KeycloakUserService {

    UserRegistrationRecord createUser(UserRegistrationRecord userRegistrationRecord);
    UserRepresentation getUserById(String userId);
    void deleteUserById(String userId);
    void emailVerification(String userId);
    void forgotPassword(String username);
    void assignRoleToUser(String userId, String role);
    void deleteRoleFromUser(String userId, String role);
    List<RoleRepresentation> getRoles(String userId);
}

