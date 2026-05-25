package com.singoo.app.domains.song.dto;

import java.util.UUID;

public class SongListDto {
    private UUID id;
    private String title;
    private String artist;
    private String youtubeVideoId;
    private String difficulty;
    private String tierRequired;

    public SongListDto() {}

    public SongListDto(UUID id, String title, String artist, String youtubeVideoId, String difficulty, String tierRequired) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.youtubeVideoId = youtubeVideoId;
        this.difficulty = difficulty;
        this.tierRequired = tierRequired;
    }


    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getYoutubeVideoId() { return youtubeVideoId; }
    public void setYoutubeVideoId(String youtubeVideoId) { this.youtubeVideoId = youtubeVideoId; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getTierRequired() { return tierRequired; }
    public void setTierRequired(String tierRequired) { this.tierRequired = tierRequired; }
}