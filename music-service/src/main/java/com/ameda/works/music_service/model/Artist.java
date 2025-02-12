package com.ameda.works.music_service.model;


import com.ameda.works.music_service.model.relationship.AlbumRelationShip;
import com.ameda.works.music_service.model.relationship.ArtistRelationship;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Artist")
@Getter
@Setter
@Builder
public class Artist {

    @Id
    private String id;
    private String name;

    @Relationship(value = "BELONGS_TO_GENRE")
    private Genre genre;

    @Relationship("CREATED")
    private List<ArtistRelationship> songs;

    @Relationship("CREATED")
    private List<AlbumRelationShip> albums;

}
