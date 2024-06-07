package com.northcodes.recordshop.service;

import com.northcodes.recordshop.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    public List<Album> getCompleteListOfAlbums();
    Album addAlbumItem(Album album);
    Optional<Album> getAlbumById(long id);

}
