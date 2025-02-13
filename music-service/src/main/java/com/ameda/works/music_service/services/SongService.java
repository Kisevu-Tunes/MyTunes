package com.ameda.works.music_service.services;

import com.ameda.works.music_service.dto.SongRecord;
import com.ameda.works.music_service.model.Song;

public interface SongService {

    Song create(SongRecord songRecord,String artistId);
    void deleteById(String id);

    void userLikeASong(String songId,String userId);
    void userDisLikeASong(String songId,String userId);

}
