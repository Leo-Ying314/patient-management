package io.github.leoying314.patientservice.service.impl;

import io.github.leoying314.patientservice.dto.PatientRequestDto;
import io.github.leoying314.patientservice.mapper.PatientMapper;
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
    private final PatientMapper patientMapper;

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createPatient(PatientRequestDto patientRequestDto) {
        return patientRepository.save(patientMapper.fromDto(patientRequestDto));
    }
}
