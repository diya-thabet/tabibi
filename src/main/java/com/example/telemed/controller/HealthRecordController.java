package com.example.telemed.controller;

import com.example.telemed.dto.HealthRecordDTO;
import com.example.telemed.entity.HealthRecord;
import com.example.telemed.service.HealthRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/records")
public class HealthRecordController {

    @Autowired
    private HealthRecordService healthRecordService;

    @PostMapping
    public ResponseEntity<HealthRecordDTO> addRecord(@Valid @RequestBody HealthRecord record) {
        HealthRecord savedRecord = healthRecordService.addRecord(record);
        return ResponseEntity.ok(new HealthRecordDTO(savedRecord));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<HealthRecordDTO>> getRecordsByPatient(@PathVariable Long id) {
        List<HealthRecord> records = healthRecordService.getRecordsByPatient(id);
        List<HealthRecordDTO> dtos = records.stream().map(HealthRecordDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping
    public ResponseEntity<List<HealthRecordDTO>> getAllRecords(@RequestHeader("X-User-Role") String role) {
        if (!"DOCTOR".equals(role)) {
            return ResponseEntity.status(403).body(null); // Forbidden
        }
        List<HealthRecord> records = healthRecordService.getAllRecords();
        List<HealthRecordDTO> dtos = records.stream().map(HealthRecordDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}