package com.imambiplob.doctorsapi.repository;

import com.imambiplob.doctorsapi.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
