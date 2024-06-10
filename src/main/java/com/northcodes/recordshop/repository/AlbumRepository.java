package com.northcodes.recordshop.repository;

import com.northcodes.recordshop.model.Album;
import com.northcodes.recordshop.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    boolean existsByAlbumName(String albumName);
    List<Album> findAlbumsByArtist(String artist);
    List<Album> findAlbumsByReleaseYear(int releaseYear);
    List<Album> findAlbumsByGenre(Genre genre);
    Album getInfoByAlbumName(String albumName);
    Album findAlbumByAlbumName(String albumName);
    Album getAlbumById(long id);

}
