package com.example.timetable.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FacultyTimetableRepository {
    private final JdbcTemplate jdbcTemplate;

    public FacultyTimetableRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAllocatedSlots(String facultyTable) {
        String sql = "SELECT day, allotted FROM " + facultyTable;
        return jdbcTemplate.queryForList(sql);
    }
}

