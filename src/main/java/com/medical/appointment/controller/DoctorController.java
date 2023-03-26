package com.medical.appointment.controller;

import com.medical.appointment.entities.Doctor;
import com.medical.appointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @PostMapping("/")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }
}
