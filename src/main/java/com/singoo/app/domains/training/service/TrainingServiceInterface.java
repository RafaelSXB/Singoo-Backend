package com.singoo.app.domains.training.service;

import java.util.UUID;

import com.singoo.app.domains.training.DTO.RankingResponseDTO;
import com.singoo.app.domains.training.DTO.TrainingSessionRequestDTO;

public interface TrainingServiceInterface {
    void submitSession(TrainingSessionRequestDTO request);
    RankingResponseDTO getSongRanking(UUID songId);
}
