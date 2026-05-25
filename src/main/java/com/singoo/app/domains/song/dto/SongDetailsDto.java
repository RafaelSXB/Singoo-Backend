package com.singoo.app.domains.song.dto;

import java.util.List;
import java.util.UUID;

public class SongDetailsDto {
    private UUID id;
    private String youtubeVideoId;
    private List<LyricDto> lyrics;

    public SongDetailsDto() {}

    public SongDetailsDto(UUID id, String youtubeVideoId, List<LyricDto> lyrics) {
        this.id = id;
        this.youtubeVideoId = youtubeVideoId;
        this.lyrics = lyrics;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getYoutubeVideoId() { return youtubeVideoId; }
    public void setYoutubeVideoId(String youtubeVideoId) { this.youtubeVideoId = youtubeVideoId; }

    public List<LyricDto> getLyrics() { return lyrics; }
    public void setLyrics(List<LyricDto> lyrics) { this.lyrics = lyrics; }
}