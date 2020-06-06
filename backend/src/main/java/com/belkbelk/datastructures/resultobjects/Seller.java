package com.belkbelk.datastructures.resultobjects;

public class Seller {

    private String username;
    private String feedbackPercentage;
    private Integer feedbackScore;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedbackPercentage() {
        return feedbackPercentage;
    }

    public void setFeedbackPercentage(String feedbackPercentage) {
        this.feedbackPercentage = feedbackPercentage;
    }

    public Integer getFeedbackScore() {
        return feedbackScore;
    }

    public void setFeedbackScore(Integer feedbackScore) {
        this.feedbackScore = feedbackScore;
    }
}
