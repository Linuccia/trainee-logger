package aston.polina.repository;

import aston.polina.model.Log;

import java.util.List;

public interface LogRepository {

    Log getById(Long id);

    List<Log> getAllByStudentId(Integer studentId);

    Log save(Log log);

    Log update(Log log);

}
