package com.northcodes.recordshop.service;

import com.northcodes.recordshop.model.Album;
import com.northcodes.recordshop.model.Genre;
import com.northcodes.recordshop.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumRepository albumRepository;
    @Override
    public List<Album> getCompleteListOfAlbums() {
        List<Album> albums = new ArrayList<>();
        albumRepository.findAll().forEach(albums::add);
        return albums;
    }

    @Override
    public Album addAlbumItem(Album album) {

        if (albumRepository.existsByAlbumName(album.getAlbumName())) {

            album.setCopiesInStock(album.getCopiesInStock() + 1);
        }
        return albumRepository.save(album);
    }

    @Override
    public Optional<Album> getAlbumById(long id) {
        return albumRepository.findById(id);
    }

    @Override
    public List<Album> getAlbumsByArtist(String artist) {
        return new ArrayList<>(albumRepository.findAlbumsByArtist(artist));
    }

    @Override
    public List<Album> getAlbumsByReleaseYear(int releaseYear) {
        return new ArrayList<>(albumRepository.findAlbumsByReleaseYear(releaseYear));
    }

    @Override
    public List<Album> getAlbumsByGenre(Genre genre) {
        return new ArrayList<>(albumRepository.findAlbumsByGenre(genre));
    }

}
