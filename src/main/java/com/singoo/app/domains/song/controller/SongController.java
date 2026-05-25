package com.singoo.app.domains.song.controller;

import com.singoo.app.common.dto.PaginatedResponse;
import com.singoo.app.domains.song.dto.SongDetailsDto;
import com.singoo.app.domains.song.dto.SongListDto;
import com.singoo.app.domains.song.service.SongServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/songs")
public class SongController {

    private final SongServiceInterface songService;

    public SongController(SongServiceInterface songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<PaginatedResponse<SongListDto>> getCatalog(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        
        PaginatedResponse<SongListDto> response = songService.getCatalog(search, page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{songId}")
    public ResponseEntity<SongDetailsDto> getSongDetails(@PathVariable UUID songId) {
        
        SongDetailsDto response = songService.getSongDetails(songId);
        return ResponseEntity.ok(response);
    }
} 
