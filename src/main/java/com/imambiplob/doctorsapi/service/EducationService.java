package com.imambiplob.doctorsapi.service;

import com.imambiplob.doctorsapi.entity.Education;
import com.imambiplob.doctorsapi.repository.EducationRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public void saveEducation(Education education) {
        educationRepository.save(education);
    }
}
