package io.github.leoying314.patientservice.mapper;

import io.github.leoying314.patientservice.dto.PatientDto;
import io.github.leoying314.patientservice.model.Patient;

public interface PatientMapper {
    Patient fromDto(PatientDto patientDto);
    PatientDto toDto(Patient patient);
}
