package aston.polina.controller;

import aston.polina.model.Log;
import aston.polina.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/logs")
public class LogController {

    @Autowired
    private LogService service;

    @PostMapping
    public Log addLog(@PathVariable Integer studentId, @RequestBody Log log) {
        return service.saveLog(studentId, log);
    }

    @PutMapping("/{id}")
    public Log updateLog(@PathVariable Long id, @RequestBody Log log) {
        return service.updateLog(id, log);
    }

    @GetMapping
    public List<Log> getLogs(@PathVariable Integer studentId) {
        return service.getLogsByStudentId(studentId);
    }

}
