package io.github.leoying314.patientservice.controller;

import io.github.leoying314.patientservice.dto.PatientRequestDto;
import io.github.leoying314.patientservice.dto.PatientResponseDto;
import io.github.leoying314.patientservice.dto.ValidationGroups;
import io.github.leoying314.patientservice.mapper.PatientMapper;
import io.github.leoying314.patientservice.service.PatientService;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
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
    public List<PatientResponseDto> getPatients() {
        return patientService.getPatients()
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

    @PostMapping
    public PatientResponseDto createPatient(
            @Validated({Default.class, ValidationGroups.OnCreate.class}) @RequestBody PatientRequestDto patientRequestDto
    ) {
        return patientMapper.toDto(patientService.createPatient(patientRequestDto));
    }

    @PutMapping(path="/{id}")
    public PatientResponseDto updatePatient(
            @PathVariable("id") UUID patientID,
            @Validated({Default.class}) @RequestBody PatientRequestDto patientRequestDto
    ) {
        return patientMapper.toDto(patientService.updatePatient(patientID, patientRequestDto));
    }

    @DeleteMapping(path="/{id}")
    public void deletePatient(
            @PathVariable("id") UUID patientId
    ) {
        patientService.deletePatient(patientId);
    }
}
