package com.singoo.app.domains.training.service;

import com.singoo.app.domains.auth.User;
import com.singoo.app.domains.auth.UserRepository;
import com.singoo.app.domains.song.model.Song;
import com.singoo.app.domains.song.repository.SongRepository;
import com.singoo.app.domains.training.DTO.RankingResponseDTO;
import com.singoo.app.domains.training.DTO.RankingRowDTO;
import com.singoo.app.domains.training.DTO.TrainingSessionRequestDTO;
import com.singoo.app.domains.training.model.TrainingSession;
import com.singoo.app.domains.training.repository.TrainingSessionRepository;
import com.singoo.app.Security.exception.custom.ResourceNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainingSessionServiceImpl implements TrainingServiceInterface {

    private final TrainingSessionRepository trainingSessionRepository;
    private final UserRepository userRepository;
    private final SongRepository songRepository;

    public TrainingSessionServiceImpl(TrainingSessionRepository trainingSessionRepository,
                               UserRepository userRepository,
                               SongRepository songRepository) {
        this.trainingSessionRepository = trainingSessionRepository;
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }

    @Override
    @Transactional
    public void submitSession(TrainingSessionRequestDTO request) {
     
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador não encontrado."));

       
        Song song = songRepository.findById(request.getSongId())
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada."));

     
        Optional<TrainingSession> existingSessionOpt = trainingSessionRepository.findByUserIdAndSongId(user.getId(), song.getId());

        if (existingSessionOpt.isPresent()) {
            TrainingSession session = existingSessionOpt.get();
            
           
            session.setPointsEarned(session.getPointsEarned() + request.getPointsEarned());
            
         
            if (request.getAccuracyPercentage().compareTo(session.getAccuracyPercentage()) > 0) {
                session.setAccuracyPercentage(request.getAccuracyPercentage());
            }
            
            trainingSessionRepository.save(session);
            
        } else {
            TrainingSession newSession = new TrainingSession(
                    user,
                    song,
                    request.getAccuracyPercentage(),
                    request.getPointsEarned()
            );
            trainingSessionRepository.save(newSession);
        }

       
        int currentPoints = user.getTotalPoints() != null ? user.getTotalPoints() : 0;
        user.setTotalPoints(currentPoints + request.getPointsEarned());
        userRepository.save(user);
    }

    @Override
    public RankingResponseDTO getSongRanking(UUID songId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador não encontrado."));

        
        List<RankingRowDTO> fullRanking = trainingSessionRepository.getGlobalRankingBySong(songId);

        Integer currentUserRank = null;
        Integer currentUserPoints = 0;
        BigDecimal currentUserAccuracy = BigDecimal.ZERO;

      
        for (int i = 0; i < fullRanking.size(); i++) {
            RankingRowDTO row = fullRanking.get(i);
            row.setPosition(i + 1);

            if (row.getUserId().equals(currentUser.getId())) {
                currentUserRank = row.getPosition();
                currentUserPoints = row.getUserAllPoints();
                currentUserAccuracy = row.getUserHighAccuracy();
            }
        }

      
        int limit = Math.min(fullRanking.size(), 10);
        List<RankingRowDTO> top10 = fullRanking.subList(0, limit);

        return new RankingResponseDTO(
                currentUserRank,
                currentUserPoints,
                currentUserAccuracy,
                top10
        );
    }
}