package com.example.timetable.controller;
//this for generating time table
import com.example.timetable.dto.TimeTableRequest;
import com.example.timetable.service.TimeTableService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timetable")
public class TimeTableController {

    private final TimeTableService service;

    public TimeTableController(TimeTableService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public String[][] generateTimeTable(@RequestBody TimeTableRequest request) {
        return service.generateTimeTable(request.getFaculties(), request.getLabs(),request.getClassRoom());
    }
}
