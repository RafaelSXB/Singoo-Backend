package com.singoo.app.domains.community.dto;

public class SongRequestDto {
    private String songName;
    private String artistName;

    public SongRequestDto() {}

    public String getSongName() { return songName; }
    public void setSongName(String songName) { this.songName = songName; }
    public String getArtistName() { return artistName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }
}