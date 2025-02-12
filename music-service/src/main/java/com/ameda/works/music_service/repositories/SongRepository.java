package com.ameda.works.music_service.repositories;


import com.ameda.works.music_service.model.Song;
import com.ameda.works.music_service.model.projections.SongProjection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SongRepository extends Neo4jRepository<Song, String> {

    @Query("MATCH (song:Song {id: $songId}) RETURN song.id As id, song.name As name, song.description As description, song.status As status, song.duration As duration, song.storageId As storageId, song.storageType As storageType, song.type As type, song.year As year")
    Optional<SongProjection> findByIdProjection(@Param("songId") String id);



    @Query("MATCH (song:Song {id: $songId}), (user: User {id : $userId})" +
            " MERGE (user) -[:LIKES {createdAt: $createdAt}]-> (song)")
    void userLikeASong(@Param("songId") String songId, @Param("userId") String userId, @Param("createdAt") LocalDateTime createdAt);


    @Query("MATCH (song:Song {id: $songId})<-[relationship:LIKES]- (user: User {id : $userId})" +
            " DELETE relationship")
    void userDisLikeASong(@Param("songId") String songId, @Param("userId") String userId);

}
