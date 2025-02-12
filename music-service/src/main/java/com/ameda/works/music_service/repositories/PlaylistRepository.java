package com.ameda.works.music_service.repositories;

import com.ameda.works.music_service.model.PlayList;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PlaylistRepository extends Neo4jRepository<PlayList,String> {



    @Query("MATCH (user: User {id: $userId}), (playlist: Playlist {id: $playlistId})" +
            " MERGE (user)-[:CREATED {createdAt: $createdAt}]->(playlist)")
    void addPlaylistAndUserRelationship(@Param("playlistId") String playlistId,
                                        @Param("userId")String userId,
                                        @Param("createdAt") LocalDateTime createdAt);


    @Query("MATCH (song: Song {id: $songId}), (playlist: Playlist {id: $playlistId})" +
            " MERGE (playlist)-[:CONTAINS {createdAt: $createdAt}]->(song)")
    void addSongToPlaylist(@Param("playlistId")String playlistId,
                           @Param("songId")String songId,
                           @Param("createdAt") LocalDateTime createdAt);
    @Query("MATCH (song: Song {id: $songId}) <-[relationship:CONTAINS]- (playlist: Playlist {id: $playlistId})" +
            " DELETE relationship")
    void removeSongFromPlaylist(@Param("playlistId")String playlistId,
                                @Param("songId")String songId);
}


