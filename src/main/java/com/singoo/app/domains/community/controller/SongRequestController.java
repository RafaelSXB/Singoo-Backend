package com.singoo.app.domains.community.controller;

import com.singoo.app.domains.community.dto.SongRequestDto;
import com.singoo.app.domains.community.dto.SongRequestResponse;
import com.singoo.app.domains.community.service.SongRequestInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class SongRequestController {

    private final SongRequestInterface songRequestInterface;

    public SongRequestController(SongRequestInterface songRequestInterface) {
        this.songRequestInterface = songRequestInterface;
    }

    @PostMapping
    public ResponseEntity<SongRequestResponse> submitRequest(@RequestBody SongRequestDto requestDto) {
        SongRequestResponse response = songRequestInterface.submitSongRequest(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}