package com.imambiplob.doctorsapi.service;

import com.imambiplob.doctorsapi.entity.Training;
import com.imambiplob.doctorsapi.repository.TrainingRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public void saveTraining(Training training) {
        trainingRepository.save(training);
    }
}
