package com.example.timetable.service;

import com.example.timetable.repository.FacultyTimetableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FacultyTimetableService {
    private final FacultyTimetableRepository repository;

    public FacultyTimetableService(FacultyTimetableRepository repository) {
        this.repository = repository;
    }

    public String[][] generateTimetable(String facultyTable) {
        String[][] timetable = new String[6][8]; // 6 rows x 8 columns

        // initialize with "no class"
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                timetable[i][j] = "no class";
            }
        }

        // fetch allocated slots (day, allotted)
        List<Map<String, Object>> allocatedSlots = repository.getAllocatedSlots(facultyTable);

        for (Map<String, Object> slot : allocatedSlots) {
            String day = (String) slot.get("day");
            String allottedValue = (String) slot.get("allotted");

            String[] parts = day.split(",");
            int i = Integer.parseInt(parts[0]);
            int j = Integer.parseInt(parts[1]);

            if (i >= 0 && i < 6 && j >= 0 && j < 8) {
                timetable[i][j] = allottedValue; // use actual value instead of "allocated"
            }
        }
        return timetable;
    }
}