package com.ameda.works.music_service.services;


import com.ameda.works.music_service.model.Album;
import com.ameda.works.music_service.model.enums.Status;
import com.ameda.works.music_service.repositories.AlbumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class AlbumServiceImpl implements AlbumService{

    private final AlbumRepository albumRepository;
    private final YearService yearService;

    public AlbumServiceImpl(AlbumRepository albumRepository, YearService yearService) {
        this.albumRepository = albumRepository;
        this.yearService = yearService;
    }

    @Override
    public Album create(Album album, Integer releasedYear, String artistId) {

        Album build = Album.builder()
                .name(album.getName())
                .description(album.getDescription())
                .status(Status.DRAFT).build();
        Album save = albumRepository.save(build);
        yearService.create(releasedYear);
        albumRepository.addReleasedYearAndArtist(artistId,save.getId(),releasedYear,LocalDateTime.now());
        return save;
    }

    @Override
    public void deleteById(String id) {

        albumRepository.deleteById(id);
    }

    @Override
    public void userLikeAnAlbum(String albumId, String userId) {


        albumRepository.userLikesAlbum(userId,albumId, LocalDateTime.now());

    }

    @Override
    public void userDisLikeAnAlbum(String albumId, String userId) {

        albumRepository.userDislikeAlbum(userId,albumId);
    }


}
