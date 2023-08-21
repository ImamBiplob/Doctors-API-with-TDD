package com.imambiplob.doctorsapi.repository;

import com.imambiplob.doctorsapi.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
