package com.singoo.app.domains.song.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "song_lyrics")
public class SongLyric {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(name = "start_time_ms", nullable = false)
    private Integer startTimeMs;

    @Column(name = "end_time_ms", nullable = false)
    private Integer endTimeMs;

    @Column(name = "english_phrase", nullable = false, columnDefinition = "TEXT")
    private String englishPhrase;

    @Column(name = "portuguese_translation", nullable = false, columnDefinition = "TEXT")
    private String portugueseTranslation;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


    public SongLyric() {}

    public SongLyric(Integer startTimeMs, Integer endTimeMs, String englishPhrase, String portugueseTranslation) {
        this.startTimeMs = startTimeMs;
        this.endTimeMs = endTimeMs;
        this.englishPhrase = englishPhrase;
        this.portugueseTranslation = portugueseTranslation;
    }


    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public Song getSong() { return song; }
    public void setSong(Song song) { this.song = song; }

    public Integer getStartTimeMs() { return startTimeMs; }
    public void setStartTimeMs(Integer startTimeMs) { this.startTimeMs = startTimeMs; }

    public Integer getEndTimeMs() { return endTimeMs; }
    public void setEndTimeMs(Integer endTimeMs) { this.endTimeMs = endTimeMs; }

    public String getEnglishPhrase() { return englishPhrase; }
    public void setEnglishPhrase(String englishPhrase) { this.englishPhrase = englishPhrase; }

    public String getPortugueseTranslation() { return portugueseTranslation; }
    public void setPortugueseTranslation(String portugueseTranslation) { this.portugueseTranslation = portugueseTranslation; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}