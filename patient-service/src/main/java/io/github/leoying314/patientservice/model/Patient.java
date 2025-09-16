package io.github.leoying314.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name="name", nullable = false)
    private String name;

    @NotNull
    @Email
    @Column(name="email", unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(name="address", nullable = false)
    private String address;

    @NotNull
    @Column(name="date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name="registered_date", nullable = false, updatable = false)
    private LocalDate registeredDate;
}
