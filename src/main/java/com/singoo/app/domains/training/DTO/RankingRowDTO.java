package com.singoo.app.domains.training.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public class RankingRowDTO {
    private UUID userId;
    
    private Integer position;
    private String userName;
    private Integer userAllPoints; 
    private BigDecimal userHighAccuracy;

    public RankingRowDTO() {}

    public RankingRowDTO(UUID userId, String userName, Integer userAllPoints, BigDecimal userHighAccuracy) {
        this.userId = userId;
        this.userName = userName;
        this.userAllPoints = userAllPoints;
        this.userHighAccuracy = userHighAccuracy;
    }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public Integer getUserAllPoints() { return userAllPoints; }
    public void setUserAllPoints(Integer userAllPoints) { this.userAllPoints = userAllPoints; }
    public BigDecimal getUserHighAccuracy() { return userHighAccuracy; }
    public void setUserHighAccuracy(BigDecimal userHighAccuracy) { this.userHighAccuracy = userHighAccuracy; }
}
