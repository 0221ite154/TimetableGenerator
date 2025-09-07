package com.example.timetable.controller;
//this is for creating faculty timetable
import com.example.timetable.service.FacultyTimetableService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty-timetable")
public class FacultyTimetableController {
    private final FacultyTimetableService service;

    public FacultyTimetableController(FacultyTimetableService service) {
        this.service = service;
    }

    @GetMapping("/{facultyId}")
    public String[][] getTimetable(@PathVariable String facultyId) {
        return service.generateTimetable(facultyId);
    }
}
