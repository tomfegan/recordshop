package com.northcodes.recordshop.repository;

import com.northcodes.recordshop.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    boolean existsByAlbumName(String albumName);

}
