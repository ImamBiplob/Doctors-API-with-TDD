package com.imambiplob.doctorsapi.service;

import com.imambiplob.doctorsapi.entity.Experience;
import com.imambiplob.doctorsapi.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }
}
