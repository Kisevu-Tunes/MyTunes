package com.ameda.works.music_service.services;

import com.ameda.works.music_service.model.Artist;

public interface ArtistService {

    Artist createNew(Artist artist);
    Artist findById(String id);
    void deleteById(String id);
    void addArtistAndYearRelationship(String artistId, Integer integer, String id,String genreId);

}
