package com.ameda.works.user_service.controller;

import com.ameda.works.user_service.dto.UserDTO;
import com.ameda.works.user_service.mapper.DTOMapper;
import com.ameda.works.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserApi {


    private final UserService userService;
    private final DTOMapper dtoMapper;

    public UserApi(UserService userService, DTOMapper dtoMapper) {
        this.userService = userService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user){
        userService.save(dtoMapper.map(user));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        return ResponseEntity.ok(dtoMapper.map(userService.getById(id)));
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable String id){
        userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id,
                                        @RequestBody  UserDTO userDTO){
        userService.update(dtoMapper.map(userDTO),id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
