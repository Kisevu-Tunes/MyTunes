package com.ameda.works.music_service.services;


import com.ameda.works.music_service.dto.UserRegistrationRequestRecord;
import com.ameda.works.music_service.model.Artist;
import com.ameda.works.music_service.model.User;
import com.ameda.works.music_service.model.projections.UserProjection;
import com.ameda.works.music_service.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@Slf4j

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ArtistService artistService;

    public UserServiceImpl(UserRepository userRepository, ArtistService artistService) {
        this.userRepository = userRepository;
        this.artistService = artistService;
    }

    @Override
    public User createUser(UserRegistrationRequestRecord requestRecord) {

        User user1 = User.builder()
                .name(requestRecord.name())
                .dob(requestRecord.dob())
                .id(requestRecord.id())
                .gender(requestRecord.gender())
                .language(requestRecord.language())
                .countryIso2(requestRecord.countryIso2())
                .build();

        Optional<UserProjection> userProjectionOptional = userRepository.findByIdProjection(requestRecord.id());
        if(userProjectionOptional.isPresent()){
            throw new RuntimeException(String.format("User with id %s already exists",requestRecord.id()));
        }

        User save = userRepository.save(user1);
        if(requestRecord.artist()){
            Artist artist = artistService.createNew(Artist.builder().id(requestRecord.id()).name(requestRecord.name()).build());
            userRepository.addArtistAndUserRelationship(save.getId(),requestRecord.id(), LocalDateTime.now());
        }
        return save;
    }

    @Override
    public void deleteByUserId(String id) {

    }

    @Override
    public void userFollowArtist(String userId, String artistId) {


        userRepository.userFollowArtist(userId,artistId, LocalDateTime.now());
    }

    @Override
    public void userUnFollowArtist(String userId, String artistId) {
        userRepository.userUnFollowArtist(userId,artistId);
    }


}
