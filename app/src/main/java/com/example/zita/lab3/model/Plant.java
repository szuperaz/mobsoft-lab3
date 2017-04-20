package com.example.zita.lab3.model;

import com.orm.dsl.Table;

@Table
public class Plant {
    private Long id = null;
    private String profileImageUrl;
    private String name;
    private String type;
    private boolean isFavourite;
    private String photoUrl;
    private String description;
    private String plantationTime;
    private String pickingTime;

    public Plant() {}

    public Plant(
            Long id,
            String profileImageUrl,
            String name,
            String type,
            boolean isFavourite,
            String photoUrl,
            String description,
            String plantationTime,
            String pickingTime
    ) {
        this.id = id;
        this.profileImageUrl = profileImageUrl;
        this.name = name;
        this.type = type;
        this.isFavourite = isFavourite;
        this.photoUrl = photoUrl;
        this.description = description;
        this.plantationTime = plantationTime;
        this.pickingTime = pickingTime;
    }

    public Long getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getPlantationTime() {
        return plantationTime;
    }

    public String getPickingTime() {
        return pickingTime;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlantationTime(String plantationTime) {
        this.plantationTime = plantationTime;
    }

    public void setPickingTime(String pickingTime) {
        this.pickingTime = pickingTime;
    }
}
