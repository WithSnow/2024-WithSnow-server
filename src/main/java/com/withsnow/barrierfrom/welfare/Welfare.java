package com.withsnow.barrierfrom.welfare;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

/**
 * Welfare 엔티티 클래스입니다.
 */
@Entity
public class Welfare {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String contactInfo;
    private LocalDateTime createdAt;
    private boolean hasStairs;
    private String stairsDescription;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isHasStairs() {
        return hasStairs;
    }

    public void setHasStairs(boolean hasStairs) {
        this.hasStairs = hasStairs;
    }

    public String getStairsDescription() {
        return stairsDescription;
    }

    public void setStairsDescription(String stairsDescription) {
        this.stairsDescription = stairsDescription;
    }
}
