package aston.polina.controller;

import aston.polina.model.Student;
import aston.polina.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeStudent(@PathVariable Integer id) {
        return service.deleteStudent(id) ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

}