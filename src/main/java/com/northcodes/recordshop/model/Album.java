package com.northcodes.recordshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "albums")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Album extends MusicRecord {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String artist;
    @Column(nullable = false)
    private String albumName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(nullable = false)
    private int releaseYear;
    @Column(nullable = false)
    private int copiesInStock;

//    @JsonCreator
//    public Album(@JsonProperty(value = "artist", required = true) String artist,
//                 @JsonProperty(value = "albumName", required = true) String albumName,
//                 @JsonProperty(value = "genre", required = true) Genre genre,
//                 @JsonProperty(value = "releaseYear", required = true) int releaseYear,
//                 @JsonProperty(value = "releaseYear", required = true) int copiesInStock) {
//            this.artist = artist;
//            this.albumName = albumName;
//            this.genre = genre;
//            this.releaseYear = releaseYear;
//            this.copiesInStock = copiesInStock;    }
//
}

