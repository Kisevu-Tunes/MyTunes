package com.ameda.works.music_service.dto;

import com.ameda.works.music_service.model.enums.SongType;
import com.ameda.works.music_service.model.enums.StorageType;

import java.time.LocalDateTime;

public record SongRecord(
        String title,
        String storageId,
        LocalDateTime releaseDate,
        Integer releaseYear,
        String albumId,
        String genreId,
        Long duration,
        StorageType storageType,
        SongType songType) {
}
