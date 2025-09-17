package io.github.leoying314.patientservice.service;

import io.github.leoying314.patientservice.dto.PatientRequestDto;
import io.github.leoying314.patientservice.model.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<Patient> getPatients();
    Patient createPatient(PatientRequestDto patientRequestDto);
    Patient updatePatient(UUID patientId, PatientRequestDto patientRequestDto);
    void deletePatient(UUID patientId);
}
