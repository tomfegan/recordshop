package com.northcodes.recordshop.service;

import com.northcodes.recordshop.model.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> getCompleteListOfAlbums();
    Album addAlbumItem(Album album);

}
