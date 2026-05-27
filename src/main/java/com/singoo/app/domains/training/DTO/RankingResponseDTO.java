package com.singoo.app.domains.training.DTO;

import java.math.BigDecimal;
import java.util.List;

public class RankingResponseDTO {
    private Integer userCurrentRank;
    private Integer userAllPoints; 
    private BigDecimal userHighAccuracy;
    private List<RankingRowDTO> topRanking;

    public RankingResponseDTO() {}

    public RankingResponseDTO(Integer userCurrentRank, Integer userAllPoints, BigDecimal userHighAccuracy, List<RankingRowDTO> topRanking) {
        this.userCurrentRank = userCurrentRank;
        this.userAllPoints = userAllPoints;
        this.userHighAccuracy = userHighAccuracy;
        this.topRanking = topRanking;
    }

    public Integer getUserCurrentRank() { return userCurrentRank; }
    public void setUserCurrentRank(Integer userCurrentRank) { this.userCurrentRank = userCurrentRank; }
    public Integer getUserAllPoints() { return userAllPoints; }
    public void setUserAllPoints(Integer userAllPoints) { this.userAllPoints = userAllPoints; }
    public BigDecimal getUserHighAccuracy() { return userHighAccuracy; }
    public void setUserHighAccuracy(BigDecimal userHighAccuracy) { this.userHighAccuracy = userHighAccuracy; }
    public List<RankingRowDTO> getTopRanking() { return topRanking; }
    public void setTopRanking(List<RankingRowDTO > topRanking) { this.topRanking = topRanking; }
}