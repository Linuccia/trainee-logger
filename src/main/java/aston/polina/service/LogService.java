package aston.polina.service;

import aston.polina.model.Log;
import aston.polina.model.Student;
import aston.polina.repository.LogRepository;
import aston.polina.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class LogService {

    private final LogRepository logRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public LogService(LogRepository logRepository, StudentRepository studentRepository) {
        this.logRepository = logRepository;
        this.studentRepository = studentRepository;
    }

    public List<Log> getLogsByStudentId(Integer studentId) {
        return logRepository.getAllByStudentId(studentId);
    }

    public Log saveLog(Integer studentId, Log log) {
        Student student = studentRepository.getById(studentId);
        if (student == null) {
            return null;
        }
        log.setStudent(student);
        log.setDate(new Date(System.currentTimeMillis()));
        return logRepository.save(log);
    }

    public Log updateLog(Long id, Log log) {
        Log old = logRepository.getById(id);
        old.setMessage(log.getMessage());
        return logRepository.update(old);
    }

}
