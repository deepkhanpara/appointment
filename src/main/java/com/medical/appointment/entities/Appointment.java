package com.medical.appointment.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    int id;

    @Column(name = "patient_name")
    String patientName;

    @Column(name = "patient_email_id")
    String patientEmailId;

    @Column(name = "patient_contact_no")
    String patientContactNo;

    @Column(name = "patient_date_of_birth")
    LocalDate patientDateOfBirth;

    @Column(name = "appointment_date_time")
    LocalDateTime appointmentDateTime;

    @ManyToOne
    private Doctor doctor;
}
