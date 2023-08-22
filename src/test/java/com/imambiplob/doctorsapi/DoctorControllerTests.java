package com.imambiplob.doctorsapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imambiplob.doctorsapi.entity.*;
import com.imambiplob.doctorsapi.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DoctorControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    @BeforeEach
    void setup(){
        doctorRepository.deleteAll();
        educationRepository.deleteAll();
        experienceRepository.deleteAll();
        specialityRepository.deleteAll();
        trainingRepository.deleteAll();
    }

    @Test
    public void saveDoctorTest() throws Exception {
        Speciality speciality = Speciality.builder().name("Neurology").build();
        List<Speciality> specialities = List.of(specialityRepository.save(speciality));

        Training training = Training.builder().name("training1").build();
        List<Training> trainings = List.of(training);

        Education education = Education.builder().degree("MBBS").instituteName("Dhaka Medical College").build();
        List<Education> educations = List.of(education);

        Experience experience = Experience.builder().designation("Intern Doctor").organizationName("DMC").build();
        List<Experience> experiences = List.of(experience);

        Doctor doctor = Doctor.builder()
                .name("Monir")
                .title("Dr.")
                .bmdcNumber("abc123")
                .doctorType(DoctorType.valueOf("MEDICAL"))
                .speciality(specialities)
                .trainings(trainings)
                .educations(educations)
                .experiences(experiences)
                .build();

        ResultActions response = mockMvc.perform(post("/api/doctors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(doctor)));

        response.andDo(print()).
                andExpect(status().isCreated());
    }

    @Test
    public void getListOfDoctorsTest() throws Exception {
        List<Doctor> doctorList = new ArrayList<>();

        Speciality speciality1 = Speciality.builder().name("Neurology").build();
        List<Speciality> specialities1 = List.of(specialityRepository.save(speciality1));
        doctorList.add(Doctor.builder().title("Dr.").name("Monir").bmdcNumber("abc123").doctorType(DoctorType.valueOf("MEDICAL")).speciality(specialities1).build());

        Speciality speciality2 = Speciality.builder().name("Heart").build();
        List<Speciality> specialities2 = List.of(specialityRepository.save(speciality2));
        doctorList.add(Doctor.builder().title("Dr.").name("Jahed").bmdcNumber("def123").doctorType(DoctorType.valueOf("MEDICAL")).speciality(specialities2).build());

        doctorRepository.saveAll(doctorList);

        ResultActions response = mockMvc.perform(get("/api/doctors"));

        response.andExpect(status().isOk())
                .andDo(print());
    }
}
