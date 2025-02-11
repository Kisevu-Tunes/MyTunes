package com.ameda.works.user_service.service.impl;

import com.ameda.works.user_service.model.User;
import com.ameda.works.user_service.repository.UserRepository;
import com.ameda.works.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, String userId) {
        User user1 = getById(userId);
        if(nonNull(user1)){
            user.setId(userId);
            return save(user);
        }
        throw new RuntimeException("Specified user id not found.");
    }

    @Override
    public User getById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
