package com.singoo.app.domains.community.service;

import com.singoo.app.domains.community.dto.SongRequestDto;
import com.singoo.app.domains.community.dto.SongRequestResponse;

public interface SongRequestInterface {
    SongRequestResponse submitSongRequest(SongRequestDto requestDto);
}