package com.ambiongltb.fulldashboardededdneddy.data;

public class AnnouncementDataClass {

    private String title;
    private String description;
    private String imageUrl;
    private String category;

    private Long timestamp;

    public AnnouncementDataClass(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AnnouncementDataClass(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AnnouncementDataClass(String dataTitle, String dataDesc, String dataImage, String category, Long dataTime) {
        this.title = dataTitle;
        this.description = dataDesc;
        this.imageUrl = dataImage;
        this.category = category;
        this.timestamp = dataTime;
    }
    public AnnouncementDataClass(){

    }

}

