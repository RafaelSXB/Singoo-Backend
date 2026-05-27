package com.singoo.app.domains.training.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public class TrainingSessionRequestDTO {
    private UUID songId;
    private BigDecimal accuracyPercentage;
    private Integer pointsEarned;

    public TrainingSessionRequestDTO() {}

    public UUID getSongId() { return songId; }
    public void setSongId(UUID songId) { this.songId = songId; }
    public BigDecimal getAccuracyPercentage() { return accuracyPercentage; }
    public void setAccuracyPercentage(BigDecimal accuracyPercentage) { this.accuracyPercentage = accuracyPercentage; }
    public Integer getPointsEarned() { return pointsEarned; }
    public void setPointsEarned(Integer pointsEarned) { this.pointsEarned = pointsEarned; }
}
