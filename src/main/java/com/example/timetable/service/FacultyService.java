package com.example.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FacultyService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create Table
    public String createTable(String facultyId) {
        String tableName = facultyId;
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName +
                " (day VARCHAR(20), allotted VARCHAR(20))";
        jdbcTemplate.execute(sql);
        return "Table " + tableName + " created successfully!";
    }

    // Insert Data
    public String insertData(String facultyId, String day, String allotted) {
        String tableName = facultyId;
        String sql = "INSERT INTO " + tableName + " (day, allotted) VALUES (?, ?)";
        jdbcTemplate.update(sql, day, allotted);
        return "Inserted into " + tableName + ": (" + day + ", " + allotted + ")";
    }

    // Fetch Data
    public List<Map<String, Object>> getData(String facultyId) {
        String tableName = facultyId;
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.queryForList(sql);
    }

    // Show All Tables
    public List<String> getAllTables() {
        String sql = "SHOW TABLES";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}