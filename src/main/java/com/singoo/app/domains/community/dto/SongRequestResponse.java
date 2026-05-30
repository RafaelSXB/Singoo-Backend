package com.singoo.app.domains.community.dto;

public class SongRequestResponse {
    private String message;
    private Integer pointsAwarded;

    public SongRequestResponse() {}

    public SongRequestResponse(String message, Integer pointsAwarded) {
        this.message = message;
        this.pointsAwarded = pointsAwarded;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Integer getPointsAwarded() { return pointsAwarded; }
    public void setPointsAwarded(Integer pointsAwarded) { this.pointsAwarded = pointsAwarded; }
}