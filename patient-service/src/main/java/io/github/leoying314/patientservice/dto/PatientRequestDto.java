package io.github.leoying314.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PatientRequestDto(
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Address is required")
        String address,

        @NotNull(message = "Date of birth is required")
        LocalDate dateOfBirth,

        @NotNull(
                groups = {ValidationGroups.OnCreate.class},
                message = "Registered date is required"
        )
        LocalDate registeredDate
) {
}
