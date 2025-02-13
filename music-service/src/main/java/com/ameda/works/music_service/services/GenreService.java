package com.ameda.works.music_service.services;


import com.ameda.works.music_service.model.Genre;

public interface GenreService {
     Genre create(Genre genre);
     void addArtistToGenre(String genreId, String artistId);
     void removeArtistFromGenre(String genreId, String artistId);
     void addSongToGenre(String genreId, String songId);
     void removeSongFromGenre(String genreId, String songId);

}
