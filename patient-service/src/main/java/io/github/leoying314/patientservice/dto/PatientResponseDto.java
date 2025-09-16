package io.github.leoying314.patientservice.dto;

import java.time.LocalDate;
import java.util.UUID;

public record PatientResponseDto(
        UUID id,
        String name,
        String email,
        String address,
        LocalDate dateOfBirth
) {
}
