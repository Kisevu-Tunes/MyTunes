package com.ameda.works.music_service.model.projections;


import java.time.LocalDate;

public interface UserProjection {

    String getId();

    String getName();

    LocalDate getDob();

    String getGender();

    String getLanguage();

    String getCountryIso2();

}
