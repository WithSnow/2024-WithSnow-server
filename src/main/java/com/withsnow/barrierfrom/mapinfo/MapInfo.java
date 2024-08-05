package com.withsnow.barrierfrom.mapinfo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "map_info")
public class MapInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mapId;
    private Double latitude;
    private Double longitude;
    private String name;
    private String address;
    private String phoneNumber;
    private String businessInfo;
    private String openingHours;
    private Boolean elevator;
    private Boolean stepFree;
    private Boolean wheelchairAccessible;
    private Boolean ramp;
    private Float rating;
    @Enumerated(EnumType.STRING)
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getters and setters
    public Long getMapId() {
        return mapId;
    }
    public void setMapId(Long mapId) {
        this.mapId = mapId;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getBusinessInfo() {
        return businessInfo;
    }
    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }
    public String getOpeningHours() {
        return openingHours;
    }
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
    public Boolean getElevator() {
        return elevator;
    }
    public void setElevator(Boolean elevator) {
        this.elevator = elevator;
    }
    public Boolean getStepFree() {
        return stepFree;
    }
    public void setStepFree(Boolean stepFree) {
        this.stepFree = stepFree;
    }
    public Boolean getWheelchairAccessible() {
        return wheelchairAccessible;
    }
    public void setWheelchairAccessible(Boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }
    public Boolean getRamp() {
        return ramp;
    }
    public void setRamp(Boolean ramp) {
        this.ramp = ramp;
    }
    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

enum Category {
    레스토랑, 카페, 베이커리, 베프픽
}
