package com.ameda.works.music_service.services;

import com.ameda.works.music_service.dto.SongRecord;
import com.ameda.works.music_service.model.Song;
import com.ameda.works.music_service.model.enums.Status;
import com.ameda.works.music_service.repositories.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class SongServiceImpl implements SongService{

    private final SongRepository repository;
    private final YearService yearService;
    private final ArtistService artistService;

    public SongServiceImpl(SongRepository repository, YearService yearService, ArtistService artistService) {
        this.repository = repository;
        this.yearService = yearService;
        this.artistService = artistService;
    }

    @Override
    public Song create(SongRecord songRecord, String artistId) {


        Song song = Song.builder()
                .name(songRecord.title())
                .storageId(songRecord.storageId())
                .storageType(songRecord.storageType())
                .type(songRecord.songType())
                .duration(songRecord.duration())
                .releasedDate(songRecord.releaseDate())
                .status(Status.DRAFT)
                .build();

        Song saved = repository.save(song);
        yearService.create(songRecord.releaseYear());
        artistService.addArtistAndYearRelationship(artistId,songRecord.releaseYear(),
                saved.getId(),songRecord.genreId());

        return saved;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void userLikeASong(String songId, String userId) {

        repository.userLikeASong(songId,userId, LocalDateTime.now());

    }

    @Override
    public void userDisLikeASong(String songId, String userId) {
        repository.userDisLikeASong(songId,userId);

    }

}
