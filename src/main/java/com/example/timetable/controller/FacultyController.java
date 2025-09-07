package com.example.timetable.controller;

//this is for adding new faculty to database.
import com.example.timetable.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // Create new faculty table
    @PostMapping("/createTable/{facultyId}")
    public String createTable(@PathVariable String facultyId) {
        return facultyService.createTable(facultyId);
    }

    // Insert faculty details
    @PostMapping("/insert/{facultyId}")
    public String insertData(@PathVariable String facultyId,
                             @RequestParam String day,
                             @RequestParam String allotted) {
        return facultyService.insertData(facultyId, day, allotted);
    }

    // Get faculty table data
    @GetMapping("/getData/{facultyId}")
    public List<Map<String, Object>> getData(@PathVariable String facultyId) {
        return facultyService.getData(facultyId);
    }

    // Show all tables
    @GetMapping("/showTables")
    public List<String> showTables() {
        return facultyService.getAllTables();
    }
}

