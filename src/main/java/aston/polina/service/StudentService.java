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

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

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
