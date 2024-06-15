package com.northcodes.recordshop.service;

import com.northcodes.recordshop.model.Album;
import com.northcodes.recordshop.model.Genre;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    public List<Album> getCompleteListOfAlbums();
    Album addAlbumItemToStock(Album album);
    Optional<Album> getAlbumById(long id);
    List<Album> getAlbumsByArtist(String artist);
    List<Album> getAlbumsByReleaseYear(int releaseYear);
    List<Album> getAlbumsByGenre(Genre genre);
    Album getAlbumInfoByName(String albumName);
    String deleteAllAlbumStockById(long id);
    Album reduceAlbumStockByAlbumName(String albumName);
    Album updateAlbum(Album albumToUpdate, Long id);



}
