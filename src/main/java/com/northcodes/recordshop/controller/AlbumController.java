package com.northcodes.recordshop.controller;

import com.northcodes.recordshop.model.Album;
import com.northcodes.recordshop.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recordShop")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getCompleteListOfAlbums(), HttpStatus.OK);
    }
    @PostMapping("/addalbum")
    public ResponseEntity<Album> postJoke(@RequestBody Album postedAlbum) {
        System.out.println("Test");
        Album addedAlbum = albumService.addAlbumItem(postedAlbum);
        return new ResponseEntity<>(addedAlbum, HttpStatus.CREATED);
    }
}
