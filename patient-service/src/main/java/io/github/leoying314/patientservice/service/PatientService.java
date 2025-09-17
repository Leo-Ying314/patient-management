package io.github.leoying314.patientservice.service;

import io.github.leoying314.patientservice.dto.PatientRequestDTO;
import io.github.leoying314.patientservice.model.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<Patient> getPatients();
    Patient createPatient(PatientRequestDTO patientRequestDto);
    Patient updatePatient(UUID patientId, PatientRequestDTO patientRequestDto);
    void deletePatient(UUID patientId);
}
