package com.singoo.app.domains.song.dto;

public class LyricDto {
    private Integer startTimeMs;
    private Integer endTimeMs;
    private String englishPhrase;
    private String portugueseTranslation;

    public LyricDto() {}

    public LyricDto(Integer startTimeMs, Integer endTimeMs, String englishPhrase, String portugueseTranslation) {
        this.startTimeMs = startTimeMs;
        this.endTimeMs = endTimeMs;
        this.englishPhrase = englishPhrase;
        this.portugueseTranslation = portugueseTranslation;
    }

    public Integer getStartTimeMs() { return startTimeMs; }
    public void setStartTimeMs(Integer startTimeMs) { this.startTimeMs = startTimeMs; }

    public Integer getEndTimeMs() { return endTimeMs; }
    public void setEndTimeMs(Integer endTimeMs) { this.endTimeMs = endTimeMs; }

    public String getEnglishPhrase() { return englishPhrase; }
    public void setEnglishPhrase(String englishPhrase) { this.englishPhrase = englishPhrase; }

    public String getPortugueseTranslation() { return portugueseTranslation; }
    public void setPortugueseTranslation(String portugueseTranslation) { this.portugueseTranslation = portugueseTranslation; }
}