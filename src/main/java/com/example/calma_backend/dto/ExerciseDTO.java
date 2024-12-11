package com.example.calma_backend.dto;

public class ExerciseDTO {
    private String title;
    private String description;
    private String category;
    private String audioUrl;

    public ExerciseDTO(String title, String description, String category, String audioUrl) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.audioUrl = audioUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }
}
