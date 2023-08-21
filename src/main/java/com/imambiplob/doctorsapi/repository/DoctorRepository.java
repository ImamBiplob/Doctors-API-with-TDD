package com.imambiplob.doctorsapi.repository;

import com.imambiplob.doctorsapi.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
