package com.ameda.works.music_service.services;

import com.ameda.works.music_service.dto.UserRegistrationRequestRecord;
import com.ameda.works.music_service.model.User;

public interface UserService {

    User createUser(UserRegistrationRequestRecord user);
    void deleteByUserId(String id);
    void userFollowArtist(String userId,String artistId);
    void userUnFollowArtist(String userId,String artistId);

}
