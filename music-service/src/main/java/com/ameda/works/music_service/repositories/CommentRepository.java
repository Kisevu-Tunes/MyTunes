package com.ameda.works.music_service.repositories;


import com.ameda.works.music_service.model.Comment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends Neo4jRepository<Comment,String> {


    @Query("MATCH (user:User {id: $userId})" +
            "            MATCH (comment:Comment {id: $commentId})" +
            "            MATCH (song:Song {id: $songId})" +
            "            MERGE (user)-[:POSTED_COMMENT]->(comment)" +
            "            MERGE (comment)-[:HAS_COMMENT]->(song)")
    void addCommentRelationship(@Param("commentId")String commentId,
                                @Param("songId") String songId,
                                @Param("userId")String userId);
}

