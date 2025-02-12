package com.ameda.works.user_service.service;

import com.ameda.works.user_service.model.StorageProviders;
import com.ameda.works.user_service.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User save(User user);
    User update(User user, String userId);
    User getById(String userId);
    void deleteUser(String userId);
    void uploadProfilePicture(String id, String key, MultipartFile file, StorageProviders storageProvider) throws Exception;
}
