package com.ameda.works.music_service.services;

import com.ameda.works.music_service.model.PlayList;
import com.ameda.works.music_service.repositories.PlaylistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PlayListServiceImpl implements PlayListService{

    private final PlaylistRepository playlistRepository;

    public PlayListServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public PlayList create(PlayList playlist, String userId) {

        PlayList playlist1 = PlayList.builder()
                .title(playlist.getTitle())
                .description(playlist.getDescription()).build();
        PlayList saved = playlistRepository.save(playlist1);
        playlistRepository.addPlaylistAndUserRelationship(saved.getId(),userId, LocalDateTime.now());
        return saved;
    }

    @Override
    public void deleteById(String id) {

        playlistRepository.deleteById(id);

    }

    @Override
    public void addSongIntoPlaylist(String playlistId, String songId) {

        playlistRepository.addSongToPlaylist(playlistId,songId, LocalDateTime.now());

    }

    @Override
    public void removeSongFromPlaylist(String playlistId, String songId) {

        playlistRepository.removeSongFromPlaylist(playlistId,songId);

    }

}

