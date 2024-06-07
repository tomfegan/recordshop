package com.northcodes.recordshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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
}
