package com.medical.appointment.controller;

import com.medical.appointment.entities.Appointment;
import com.medical.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/")
    List<Appointment> getAppointments() {
        return appointmentService.getAppointments();
    }

    @PostMapping("/")
    ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }

    @PutMapping("/")
    ResponseEntity<Object> updateAppointment(@RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment);
    }
}
