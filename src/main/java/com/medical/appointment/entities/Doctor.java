package com.medical.appointment.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    int id;

    String name;

    String specification;

    @Column(name = "availability_from")
    LocalDateTime availabilityFrom;

    @Column(name = "availability_to")
    LocalDateTime availabilityTo;

}
