package com.singoo.app.domains.training.model;

import com.singoo.app.domains.auth.User;
import com.singoo.app.domains.song.model.Song;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "training_sessions", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "song_id"}))
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(name = "accuracy_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal accuracyPercentage;

    @Column(name = "points_earned", nullable = false)
    private Integer pointsEarned; 

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


    public TrainingSession() {}

    public TrainingSession(User user, Song song, BigDecimal accuracyPercentage, Integer pointsEarned) {
        this.user = user;
        this.song = song;
        this.accuracyPercentage = accuracyPercentage;
        this.pointsEarned = pointsEarned;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Song getSong() { return song; }
    public void setSong(Song song) { this.song = song; }
    public BigDecimal getAccuracyPercentage() { return accuracyPercentage; }
    public void setAccuracyPercentage(BigDecimal accuracyPercentage) { this.accuracyPercentage = accuracyPercentage; }
    public Integer getPointsEarned() { return pointsEarned; }
    public void setPointsEarned(Integer pointsEarned) { this.pointsEarned = pointsEarned; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}