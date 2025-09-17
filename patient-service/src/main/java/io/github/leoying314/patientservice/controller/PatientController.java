package io.github.leoying314.patientservice.controller;

import io.github.leoying314.patientservice.dto.PatientRequestDTO;
import io.github.leoying314.patientservice.dto.PatientResponseDTO;
import io.github.leoying314.patientservice.dto.ValidationGroups;
import io.github.leoying314.patientservice.mapper.PatientMapper;
import io.github.leoying314.patientservice.model.Patient;
import io.github.leoying314.patientservice.service.PatientService;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patientDTOs = patientService.getPatients()
                .stream()
                .map(patientMapper::toDTO)
                .toList();
        return ResponseEntity.ok().body(patientDTOs);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({Default.class, ValidationGroups.OnCreate.class}) @RequestBody PatientRequestDTO patientRequestDTO
    ) {
        Patient newPatient = patientService.createPatient(patientRequestDTO);
        PatientResponseDTO newPatientDTO = patientMapper.toDTO(newPatient);
        return ResponseEntity.ok().body(newPatientDTO);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(
            @PathVariable("id") UUID patientID,
            @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO
    ) {
        Patient updatedPatient = patientService.updatePatient(patientID, patientRequestDTO);
        PatientResponseDTO updatedPatientDTO = patientMapper.toDTO(updatedPatient);
        return ResponseEntity.ok().body(updatedPatientDTO);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deletePatient(
            @PathVariable("id") UUID patientId
    ) {
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }
}
