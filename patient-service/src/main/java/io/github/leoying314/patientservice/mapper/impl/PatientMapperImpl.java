package io.github.leoying314.patientservice.mapper.impl;

import io.github.leoying314.patientservice.dto.PatientDto;
import io.github.leoying314.patientservice.mapper.PatientMapper;
import io.github.leoying314.patientservice.model.Patient;

public class PatientMapperImpl implements PatientMapper {
    @Override
    public Patient fromDto(PatientDto patientDto) {
        return new Patient(
                patientDto.id(),
                patientDto.name(),
                patientDto.email(),
                patientDto.address(),
                patientDto.dateOfBirth(),
                null
        );
    }

    @Override
    public PatientDto toDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth()
        );
    }
}
