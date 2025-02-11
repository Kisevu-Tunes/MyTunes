package com.ameda.works.user_service.service;

import com.ameda.works.user_service.model.User;

public interface UserService {

    User save(User user);
    User update(User user, String userId);
    User getById(String userId);
    void deleteUser(String userId);
}
