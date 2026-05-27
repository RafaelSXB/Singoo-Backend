package com.singoo.app.domains.training.controller;

import com.singoo.app.domains.training.DTO.RankingResponseDTO;
import com.singoo.app.domains.training.DTO.TrainingSessionRequestDTO;
import com.singoo.app.domains.training.service.TrainingSessionServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/training")
public class TrainingSessionController {

    private final TrainingSessionServiceImpl trainingService;

    public TrainingSessionController(TrainingSessionServiceImpl trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/sessions")
    public ResponseEntity<Void> submitSession(@RequestBody TrainingSessionRequestDTO request) {
        trainingService.submitSession(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/songs/{songId}/ranking")
    public ResponseEntity<RankingResponseDTO> getSongRanking(@PathVariable UUID songId) {
        RankingResponseDTO response = trainingService.getSongRanking(songId);
        return ResponseEntity.ok(response);
    }
} 
