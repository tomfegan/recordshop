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
    public Album addAlbumItemToStock(Album album) {
        if (!albumRepository.existsByAlbumName(album.getAlbumName())) {
            album.setCopiesInStock(album.getCopiesInStock() + 1);
            return albumRepository.save(album);
        } else { // https://www.baeldung.com/spring-data-crud-repository-save
            Album albumInDB = albumRepository.findAlbumByAlbumName(album.getAlbumName());
            albumInDB.setCopiesInStock(albumInDB.getCopiesInStock() + 1);
            albumRepository.save(albumInDB);
            return albumInDB;
        }
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

    @Override
    public Album getAlbumInfoByName(String albumName) {
        return albumRepository.getInfoByAlbumName(albumName);
    }

    @Override
    public String deleteAllAlbumStockById(long id) {
        if (albumRepository.getAlbumById(id) != null) {
            albumRepository.delete(albumRepository.getAlbumById(id));
            return "All stock of the album at id " + id + " has been deleted";
        } else {
            return "There was no album at id " + id + " to delete from db";
        }
    }

    @Override
    public Album reduceAlbumStockByAlbumName(String albumName) {
        if (!albumRepository.existsByAlbumName(albumName)) {
            return null;
        } else {
            Album albumInDB = albumRepository.findAlbumByAlbumName(albumName);
            if (albumInDB.getCopiesInStock() > 0) {
                albumInDB.setCopiesInStock(albumInDB.getCopiesInStock() - 1);
                albumRepository.save(albumInDB);
                return albumInDB;
            } else {
                return albumInDB;
            }
        }
    }
}