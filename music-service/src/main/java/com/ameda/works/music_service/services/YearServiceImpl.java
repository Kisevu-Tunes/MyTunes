package com.ameda.works.music_service.services;

import com.ameda.works.music_service.model.Year;
import com.ameda.works.music_service.repositories.YearRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@Slf4j
public class YearServiceImpl implements YearService{

    private  final YearRepository yearRepository;

    public YearServiceImpl(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    @Override
    public Year create(Integer year) {

        Year year1 = getById(year);

        if(nonNull(year1)){
            return  year1;
        }
        return yearRepository.save(Year.builder().id(String.valueOf(year)).year(year).build());
    }

    @Override
    public Year getById(Integer year) {
        return yearRepository.findByYear(year).orElse(null);
    }

}
