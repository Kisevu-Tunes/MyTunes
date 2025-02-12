package com.ameda.works.music_service.model.relationship;


import com.ameda.works.music_service.model.Artist;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDateTime;

@RelationshipProperties
@Getter
@Setter
public class FollowRelationship {

    @Id
    @GeneratedValue
    private Long id;
    @TargetNode
    private Artist artist;
    private LocalDateTime createdAt;

}
