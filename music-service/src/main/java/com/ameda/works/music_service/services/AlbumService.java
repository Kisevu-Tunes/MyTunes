package com.ameda.works.music_service.services;

import com.ameda.works.music_service.model.Album;

public interface AlbumService {

    Album create(Album album, Integer releasedYear, String artistId);
    void deleteById(String id);
    void userLikeAnAlbum(String albumId,String userId);
    void userDisLikeAnAlbum(String albumId,String userId);


}
