package com.ameda.works.music_service.services;

import com.ameda.works.music_service.model.PlayList;

public interface PlayListService {

    PlayList create(PlayList playlist, String userId);
    void deleteById(String id);
    void addSongIntoPlaylist(String playlistId, String songId);
    void removeSongFromPlaylist(String playlistId, String songId);


}
