package io.github.leoying314.patientservice.controller;

import io.github.leoying314.patientservice.dto.PatientRequestDto;
import io.github.leoying314.patientservice.dto.PatientResponseDto;
import io.github.leoying314.patientservice.mapper.PatientMapper;
import io.github.leoying314.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @Valid @RequestBody PatientRequestDto patientRequestDto
    ) {
        return patientMapper.toDto(patientService.createPatient(patientRequestDto));
    }
}
