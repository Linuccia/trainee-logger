package aston.polina.repository;

import aston.polina.model.Student;

import java.util.List;

public interface StudentRepository {

    Student getById(Integer id);

    List<Student> getAll();

    Student save(Student student);

    Student deleteById(Integer id);

}
