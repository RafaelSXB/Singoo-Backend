package com.singoo.app.domains.song.repository;

import com.singoo.app.domains.song.model.SongLyric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SongLyricRepository extends JpaRepository<SongLyric, UUID> {
    List<SongLyric> findBySongIdOrderByStartTimeMsAsc(UUID songId);
    
}