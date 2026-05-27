package com.singoo.app.domains.training.repository;

import com.singoo.app.domains.training.DTO.RankingRowDTO;
import com.singoo.app.domains.training.model.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface TrainingSessionRepository extends JpaRepository<TrainingSession, UUID> {

    Optional<TrainingSession> findByUserIdAndSongId(UUID userId, UUID songId);

    
    @NativeQuery("""
           SELECT u.id, u.name, ts.points_earned, ts.accuracy_percentage 
            FROM training_sessions ts
            JOIN Users u ON u.id = ts.user_id
            WHERE ts.song_id = :songId
            ORDER BY ts.points_earned DESC, ts.accuracy_percentage  DESC
            """)
    List<RankingRowDTO> getGlobalRankingBySong(@Param("songId") UUID songId);
}