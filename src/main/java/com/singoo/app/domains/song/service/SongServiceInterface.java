package com.singoo.app.domains.song.service;

import com.singoo.app.common.dto.PaginatedResponse;
import com.singoo.app.domains.song.dto.SongDetailsDto;
import com.singoo.app.domains.song.dto.SongListDto;

import java.util.UUID;

public interface SongServiceInterface {
    PaginatedResponse<SongListDto> getCatalog(String searchTerm, int page, int size);
    SongDetailsDto getSongDetails(UUID songId);
}