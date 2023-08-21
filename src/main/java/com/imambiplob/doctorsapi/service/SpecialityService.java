package com.imambiplob.doctorsapi.service;

import com.imambiplob.doctorsapi.entity.Speciality;
import com.imambiplob.doctorsapi.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public void saveSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }
}
