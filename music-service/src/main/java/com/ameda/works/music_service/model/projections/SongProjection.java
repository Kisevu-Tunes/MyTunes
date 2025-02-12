package com.ameda.works.music_service.model.projections;

import com.ameda.works.music_service.model.Year;


public interface SongProjection {
    String getId();
    String getDescription();
    String getName();
    String getStatus();
    String getDuration();
    String getStorageId();
    String getStorageType();
    String getType();
    Year getYear();

}
