package io.github.leoying314.patientservice.service.impl;

import io.github.leoying314.patientservice.model.Patient;
import io.github.leoying314.patientservice.repository.PatientRepository;
import io.github.leoying314.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }
}
