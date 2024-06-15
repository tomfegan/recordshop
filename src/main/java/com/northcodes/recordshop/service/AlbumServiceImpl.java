package com.northcodes.recordshop.service;

import com.northcodes.recordshop.exception.ApiRequestException;
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
        if (albums.size() > 0) {
            return albums;
        } else {
            throw new ApiRequestException("No albums in stock");
        }
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
        if (albumRepository.existsById(id)) {
            return albumRepository.findById(id);
        } else {
            throw new ApiRequestException("No album with id " + id + " in stock");
        }
    }
    @Override
    public List<Album> getAlbumsByArtist(String artist) {
        List<Album> list = new ArrayList<>(albumRepository.findAlbumsByArtist(artist));
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ApiRequestException("There are no albums by " + artist + " in stock");
        }
    }
    @Override
    public List<Album> getAlbumsByReleaseYear(int releaseYear) {
        List<Album> list = new ArrayList<>(albumRepository.findAlbumsByReleaseYear(releaseYear));
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ApiRequestException("There are no albums in stock that were released in " + releaseYear);
        }
    }
    @Override
    public List<Album> getAlbumsByGenre(Genre genre) {
        List<Album> list = new ArrayList<>(albumRepository.findAlbumsByGenre(genre));
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ApiRequestException("There are no albums in stock with the genre, " + genre);
        }
    }
    @Override
    public Album getAlbumInfoByName(String albumName) {
        if (albumRepository.getInfoByAlbumName(albumName) != null) {
            return albumRepository.getInfoByAlbumName(albumName);
        } else {
            throw new ApiRequestException("There was no album called " + albumName + " to delete from db");
        }
    }

    @Override
    public String deleteAllAlbumStockById(long id) {
        if (albumRepository.getAlbumById(id) != null) {
            albumRepository.delete(albumRepository.getAlbumById(id));
            return "All stock of the album at id " + id + " has been deleted";
        } else {
            throw new ApiRequestException("There was no album at id " + id + " to delete from db");
        }
    }
    @Override
    public Album reduceAlbumStockByAlbumName(String albumName) {
        if (!albumRepository.existsByAlbumName(albumName)) {
            throw new ApiRequestException("There were no albums in stock with the name " + albumName);
        } else {
            Album albumInDB = albumRepository.findAlbumByAlbumName(albumName);
            if (albumInDB.getCopiesInStock() > 0) {
                albumInDB.setCopiesInStock(albumInDB.getCopiesInStock() - 1);
                albumRepository.save(albumInDB);
                return albumInDB;
            } else {
                throw new ApiRequestException("There were no albums in stock with the name " + albumName + " to delete");
            }
        }
    }
    @Override
    public Album updateAlbum(Album albumToUpdate, Long id) {
        Optional<Album> albumInDb = albumRepository.findById(id); // this is the data in the database if there is an albumInDb with id 1
        Album updatedItem;
        if(albumInDb.isPresent()) {
            updatedItem = albumInDb.get();
            updatedItem.setAlbumName(albumToUpdate.getAlbumName());
            updatedItem.setArtist(albumToUpdate.getArtist());
            updatedItem.setGenre(albumToUpdate.getGenre());
            updatedItem.setCopiesInStock(albumInDb.get().getCopiesInStock());
            updatedItem = albumRepository.save(updatedItem);
            return updatedItem;
        } else {
            throw new ApiRequestException("Album with id " + id + " cannot be found");
        }
    }

}