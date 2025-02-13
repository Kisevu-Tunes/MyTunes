package com.ameda.works.music_service.repositories;

import com.ameda.works.music_service.model.Album;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AlbumRepository  extends Neo4jRepository<Album,String> {

    @Query("MATCH (user:User {id: $userId})" +
            "            MATCH (album:Album {id: $albumId})" +
            "            MERGE (user)-[:LIKES {createdAt: $createdAt}]->(album)")
    void userLikesAlbum(@Param("userId") String userId,
                        @Param("albumId") String albumId,
                        @Param("createdAt") LocalDateTime createdAt);


    @Query("MATCH (user:User {id: $userId}) -[relationship:LIKES]-> (album:Album {id: $albumId})" +
            " DELETE relationship")
    void userDislikeAlbum(@Param("userId")String userId,
                          @Param("albumId") String albumId);


    @Query("MATCH (artist:Artist {id: $artistId}), (album:Album {id: $albumId}), (year:Year {year: $year})" +
            " MERGE (album)-[:RELEASED_IN {created: $createdAt}]->(year)" +
            " MERGE (artist)-[:CREATED {created: $createdAt}]->(album)")
    void addReleasedYearAndArtist(@Param("artistId")String artistId,
                                  @Param("albumId") String albumId,
                                  @Param("year") Integer year,
                                  @Param("createdAt") LocalDateTime createdAt);
}

