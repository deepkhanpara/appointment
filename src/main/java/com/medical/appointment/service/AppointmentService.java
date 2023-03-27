package com.medical.appointment.service;

import com.medical.appointment.entities.Appointment;
import com.medical.appointment.entities.Doctor;
import com.medical.appointment.repository.AppointmentRepository;
import com.medical.appointment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public ResponseEntity<Object> addAppointment(Appointment appointment) {
        if(!checkAvailability(appointment)) {
            return new ResponseEntity<>(new ApiResponse("Doctor is not available on selected date and time"), HttpStatus.OK);
        }
        appointment = appointmentRepository.save(appointment);
        return new ResponseEntity<>(new ApiResponse("Appointment Booked successfully with ID:" + appointment.getId()), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateAppointment(Appointment appointment) {
        if(!checkAvailability(appointment)) {
            return new ResponseEntity<>(new ApiResponse("Doctor is not available on selected date and time"), HttpStatus.OK);
        }
        appointment = appointmentRepository.save(appointment);
        return new ResponseEntity<>(new ApiResponse("Appointment Updated successfully"), HttpStatus.OK);
    }

    public boolean checkAvailability(Appointment appointment) {
        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId()).get();
        if (appointment.getAppointmentDateTime().isAfter(doctor.getAvailabilityFrom())
                && (appointment.getAppointmentDateTime().isBefore(doctor.getAvailabilityTo()))) {
            return true;
        }
        System.out.println("Doctor is not available on selected date and time");
        return false;
    }
}
