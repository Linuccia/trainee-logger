package aston.polina.service;

import aston.polina.model.Student;
import aston.polina.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public boolean deleteStudent(Integer id) {
        return repository.deleteById(id) != null;
    }

    public List<Student> getAllStudents() {
        return repository.getAll();
    }

}
