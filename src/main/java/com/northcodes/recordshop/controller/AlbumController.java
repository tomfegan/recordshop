package com.northcodes.recordshop.controller;

import com.northcodes.recordshop.model.Album;
import com.northcodes.recordshop.model.Genre;
import com.northcodes.recordshop.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recordShop")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping("/addAlbum")
    public ResponseEntity<Album> postJoke(@RequestBody Album postedAlbum) { // To understand the @RequestBody annotation, think about it request the "body" of the HTTP POST request (which will be a JSON) and mapping it to the album object, which can be passed into the method - in other words, it's using whatever is in the body of the POST request to create the argument. More formally, this annotation tells Spring to deserialize the incoming request body into an Album object. This means the client sends an HTTP request with a JSON payload representing an album, and Spring automatically converts this JSON into an Album object that the method can work with.
        Album addedAlbum = albumService.addAlbumItem(postedAlbum);
        return new ResponseEntity<>(addedAlbum, HttpStatus.CREATED);
    }
    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getCompleteListOfAlbums(), HttpStatus.OK);
    }
    @GetMapping("/album/{id}")
    public ResponseEntity<Optional<Album>> getAlbumById(@PathVariable long id) {
        return new ResponseEntity<>(albumService.getAlbumById(id), HttpStatus.OK);
    }

    @GetMapping("/albumsBy/")
    public ResponseEntity<List<Album>> getAlbumsByArtist(@RequestParam (value = "artist")/*, required = false)*/ String artist) {
        return new ResponseEntity<>(albumService.getAlbumsByArtist(artist), HttpStatus.OK);
    }

    @GetMapping("/albumsByReleaseYear/")
    public ResponseEntity<List<Album>> getAlbumsByReleaseYear(@RequestParam (value = "releaseyear")/*, required = false)*/ int releaseYear) {
        return new ResponseEntity<>(albumService.getAlbumsByReleaseYear(releaseYear), HttpStatus.OK);
    }

    @GetMapping("/albumsByGenre/")
    public ResponseEntity<List<Album>> getAlbumsByArtist(@RequestParam (value = "genre")/*, required = false)*/ Genre genre) {
        return new ResponseEntity<>(albumService.getAlbumsByGenre(genre), HttpStatus.OK);
    }
}
