package io.github.leoying314.patientservice.service.impl;

import io.github.leoying314.patientservice.dto.PatientRequestDto;
import io.github.leoying314.patientservice.exception.EmailAlreadyExistsException;
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
        if (patientRepository.existsByEmail(patientRequestDto.email())) {
            throw new EmailAlreadyExistsException("A patient with this email already exists" + patientRequestDto.email());
        }

        return patientRepository.save(patientMapper.fromDto(patientRequestDto));
    }
}
