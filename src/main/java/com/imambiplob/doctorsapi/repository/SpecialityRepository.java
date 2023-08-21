package com.imambiplob.doctorsapi.repository;

import com.imambiplob.doctorsapi.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
