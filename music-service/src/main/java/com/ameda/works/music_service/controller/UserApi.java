package com.ameda.works.music_service.controller;


import com.ameda.works.music_service.dto.UserRegistrationRequestRecord;
import com.ameda.works.music_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(
            @RequestBody UserRegistrationRequestRecord userRegistrationRequestRecord){
        userService.createUser(userRegistrationRequestRecord);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{userId}/artist/{artistId}/follow")
    public  void followArtist(@PathVariable String userId,
                              @PathVariable String artistId){
        userService.userFollowArtist(userId,artistId);
    }


  @PutMapping("/{userId}/artist/{artistId}/unfollow")
    public  void unfollowArtist(@PathVariable String userId,
                              @PathVariable String artistId){
        userService.userUnFollowArtist(userId,artistId);
    }


}
