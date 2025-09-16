package io.github.leoying314.patientservice.mapper;

import io.github.leoying314.patientservice.dto.PatientRequestDto;
import io.github.leoying314.patientservice.dto.PatientResponseDto;
import io.github.leoying314.patientservice.model.Patient;

public interface PatientMapper {
    Patient fromDto(PatientRequestDto patientRequestDto);
    PatientResponseDto toDto(Patient patient);
}
