package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {

    Faculty create(Faculty student);

    Faculty read(long id);

    Faculty update(Faculty student);

    Faculty delete(long id);

    Collection<Faculty> readByColor(String color);
}
