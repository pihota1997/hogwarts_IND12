package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    StudentRepository repository;

    @InjectMocks
    StudentServiceImpl service;

    Student student = new Student(1L, "Harry", 11);
    @Test
    void create() {
        when(repository.save(student)).thenReturn(student);

        Student result = service.create(student);

        assertEquals(student, result);
    }

    @Test
    void read_shouldReturnStudent() {
        when(repository.findById(student.getId()))
                .thenReturn(Optional.of(student));

        Student result = service.read(student.getId());

        assertEquals(student, result);
    }

    @Test
    void read_shouldThrowExceptionWhenStudentNotInDB() {
        when(repository.findById(student.getId()))
                .thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class,
                () ->service.read(student.getId()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void readByAge() {
    }
}