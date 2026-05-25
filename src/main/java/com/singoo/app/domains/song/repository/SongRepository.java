package com.singoo.app.domains.song.repository;

import com.singoo.app.domains.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {
    
    Page<Song> findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(String title, String artist, Pageable pageable);
    
}