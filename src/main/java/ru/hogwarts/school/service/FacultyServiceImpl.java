package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;


    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty create(Faculty faculty) {

        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty read(long id) {
        Optional<Faculty> student = facultyRepository.findById(id);

        if (student.isEmpty()) {
            throw new FacultyException("Факультет не найден");
        }

        return student.get();
    }

    @Override
    public Faculty update(Faculty faculty) {

        if (facultyRepository.findById(faculty.getId()).isEmpty()) {
            throw new FacultyException("Факультет не найден");
        }

        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty delete(long id) {

        Optional<Faculty> faculty = facultyRepository.findById(id);

        if (faculty.isEmpty()) {
            throw new FacultyException("Факультет не найден");
        }

        facultyRepository.deleteById(id);
        return faculty.get();
    }

    @Override
    public Collection<Faculty> readByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }


}
