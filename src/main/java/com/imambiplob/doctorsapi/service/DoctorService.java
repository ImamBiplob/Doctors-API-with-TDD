package com.imambiplob.doctorsapi.service;

import com.imambiplob.doctorsapi.entity.Doctor;
import com.imambiplob.doctorsapi.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctor(Long id) {
        Doctor doctor = null;
        if(doctorRepository.findById(id).isPresent())
            doctor = doctorRepository.findById(id).get();

        return doctor;
    }

    public Doctor updateDoctor(long id, Doctor doctor) {
        Doctor savedDoctor = null;
        if(doctorRepository.findById(id).isPresent()) {
            savedDoctor = doctorRepository.findById(id).get();
            savedDoctor.setName(doctor.getName());
            savedDoctor.setDoctorType(doctor.getDoctorType());
            savedDoctor.setBmdcNumber(doctor.getBmdcNumber());
            savedDoctor.setTitle(doctor.getTitle());
            savedDoctor.setTrainings(doctor.getTrainings());
            savedDoctor.setEducations(doctor.getEducations());
            savedDoctor.setSpeciality(doctor.getSpeciality());
            savedDoctor.setExperiences(doctor.getExperiences());
        }

        return savedDoctor;
    }

    public Doctor deleteDoctor(long id) {
        Doctor doctor = null;
        if(doctorRepository.findById(id).isPresent()) {
            doctor = doctorRepository.findById(id).get();
            doctorRepository.deleteById(id);
        }
        return doctor;
    }
}
