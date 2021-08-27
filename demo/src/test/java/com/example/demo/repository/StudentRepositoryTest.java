package com.example.demo.repository;

import com.example.demo.enums.Gender;
import com.example.demo.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

//    @AfterEach
//    void tearDown() {
//        studentRepository.deleteAll();
//    }

    @Test
    void when_studentEmailExists_then_returnTrue() {
        // given
        String email = "lahiru@gmail.com";
        Student student = new Student("Lahiru", email, Gender.MALE);
        studentRepository.save(student);

        // when
        boolean actual = studentRepository.selectExistsEmail(email);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    void when_studentEmailDoesNotExists_then_returnFalse() {
        // given
        String email = "lahiru@gmail.com";

        // when
        boolean actual = studentRepository.selectExistsEmail(email);

        // then
        assertThat(actual).isFalse();
    }

}
