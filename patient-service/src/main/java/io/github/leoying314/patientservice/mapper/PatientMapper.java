package io.github.leoying314.patientservice.mapper;

import io.github.leoying314.patientservice.dto.PatientRequestDTO;
import io.github.leoying314.patientservice.dto.PatientResponseDTO;
import io.github.leoying314.patientservice.model.Patient;

public interface PatientMapper {
    Patient fromDTO(PatientRequestDTO patientRequestDto);
    PatientResponseDTO toDTO(Patient patient);
}
