package com.ameda.works.music_service.services;


import com.ameda.works.music_service.model.Year;

public interface YearService {

    Year create(Integer year);
    Year getById(Integer year);

}
