package com.imambiplob.doctorsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;

    @NotNull
    @Column(nullable = false)
    private String name;
}
