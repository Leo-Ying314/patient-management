package io.github.leoying314.patientservice.service.impl;

import io.github.leoying314.patientservice.dto.PatientRequestDTO;
import io.github.leoying314.patientservice.exception.EmailAlreadyExistsException;
import io.github.leoying314.patientservice.exception.PatientNotFoundException;
import io.github.leoying314.patientservice.mapper.PatientMapper;
import io.github.leoying314.patientservice.model.Patient;
import io.github.leoying314.patientservice.repository.PatientRepository;
import io.github.leoying314.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public Patient createPatient(PatientRequestDTO patientRequestDto) {
        if (patientRepository.existsByEmail(patientRequestDto.email())) {
            throw new EmailAlreadyExistsException("A patient with this email already exists: " + patientRequestDto.email());
        }

        return patientRepository.save(patientMapper.fromDTO(patientRequestDto));
    }

    @Override
    public Patient updatePatient(UUID patientId, PatientRequestDTO patientRequestDto) {
        Patient existingPatient = patientRepository.findById(patientId).orElseThrow(() ->
                new PatientNotFoundException("Patient not found with ID: " + patientId));

        // Perform validation only when email is not unique *and* belongs to another patient
        if (!patientRequestDto.email().equals(existingPatient.getEmail()) && patientRepository.existsByEmail(patientRequestDto.email())) {
            throw new EmailAlreadyExistsException("A patient with this email already exists: " + patientRequestDto.email());
        }

        existingPatient.setName(patientRequestDto.name());
        existingPatient.setEmail(patientRequestDto.email());
        existingPatient.setAddress(patientRequestDto.address());
        existingPatient.setDateOfBirth(patientRequestDto.dateOfBirth());

        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(UUID patientId) {
        patientRepository.deleteById(patientId);
    }
}
