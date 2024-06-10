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
    @Column
    private String artist;
    @Column
    private String albumName;
    @Column
    private Genre genre;
    @Column
    private int releaseYear;
    @Column
    private int copiesInStock;
}
