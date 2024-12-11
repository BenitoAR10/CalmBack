package com.example.calma_backend.dto;

public class AnxietyKitDTO {
    private String title;
    private String description;
    private String type;
    private String resourceUrl;

    public AnxietyKitDTO(String title, String description, String type, String resourceUrl) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.resourceUrl = resourceUrl;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
