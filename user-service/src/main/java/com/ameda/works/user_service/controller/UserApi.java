package com.ameda.works.user_service.controller;

import com.ameda.works.user_service.model.User;
import com.ameda.works.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserApi {


    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
