package com.imambiplob.doctorsapi.service;

import com.imambiplob.doctorsapi.entity.Doctor;
import com.imambiplob.doctorsapi.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final EducationService educationService;
    private final ExperienceService experienceService;
    private final SpecialityService specialityService;
    private final TrainingService trainingService;

    public DoctorService(DoctorRepository doctorRepository, EducationService educationService, ExperienceService experienceService, SpecialityService specialityService, TrainingService trainingService) {
        this.doctorRepository = doctorRepository;
        this.educationService = educationService;
        this.experienceService = experienceService;
        this.specialityService = specialityService;
        this.trainingService = trainingService;
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id).get();
    }
}
