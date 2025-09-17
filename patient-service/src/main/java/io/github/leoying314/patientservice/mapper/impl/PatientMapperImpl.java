package io.github.leoying314.patientservice.mapper.impl;

import io.github.leoying314.patientservice.dto.PatientRequestDTO;
import io.github.leoying314.patientservice.dto.PatientResponseDTO;
import io.github.leoying314.patientservice.mapper.PatientMapper;
import io.github.leoying314.patientservice.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientMapperImpl implements PatientMapper {
    @Override
    public Patient fromDTO(PatientRequestDTO patientRequestDto) {
        return new Patient(
                null,
                patientRequestDto.name(),
                patientRequestDto.email(),
                patientRequestDto.address(),
                patientRequestDto.dateOfBirth(),
                patientRequestDto.registeredDate()
        );
    }

    @Override
    public PatientResponseDTO toDTO(Patient patient) {
        return new PatientResponseDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth()
        );
    }
}
