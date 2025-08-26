package com.example.telemed.service;

import com.example.telemed.entity.HealthRecord;
import com.example.telemed.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthRecordService {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    public HealthRecord addRecord(HealthRecord record) {
        return healthRecordRepository.save(record);
    }

    public List<HealthRecord> getRecordsByPatient(Long patientId) {
        return healthRecordRepository.findByPatientId(patientId);
    }

    public List<HealthRecord> getAllRecords() {
        return healthRecordRepository.findAll();
    }
}