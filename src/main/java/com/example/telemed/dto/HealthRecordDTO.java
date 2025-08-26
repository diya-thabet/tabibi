// HealthRecordDTO.java
package com.example.telemed.dto;

import com.example.telemed.entity.HealthRecord;

import java.time.LocalDateTime;

public class HealthRecordDTO {
    private Long id;
    private Long patientId;
    private Double glucoseLevel;
    private String bloodPressure;
    private Double weight;
    private LocalDateTime date;

    // Constructor from HealthRecord entity
    public HealthRecordDTO(HealthRecord record) {
        this.id = record.getId();
        this.patientId = record.getPatient().getId();
        this.glucoseLevel = record.getGlucoseLevel();
        this.bloodPressure = record.getBloodPressure();
        this.weight = record.getWeight();
        this.date = record.getDate();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Double getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(Double glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}