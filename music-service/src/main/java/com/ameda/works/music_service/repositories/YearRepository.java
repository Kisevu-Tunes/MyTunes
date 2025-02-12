package com.ameda.works.music_service.repositories;

import com.ameda.works.music_service.model.Year;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YearRepository extends Neo4jRepository<Year,String> {

    Optional<Year> findByYear(Integer year);
}

