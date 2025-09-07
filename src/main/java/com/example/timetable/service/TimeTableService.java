package com.example.timetable.service;

import com.example.timetable.model.Faculty;
import com.example.timetable.model.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TimeTableService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FacultyService facultyService;

    public String[][] generateTimeTable(List<Faculty> faculties, List<Lab> labs, String className) {
        String[][] timeTable;

        while (true) {  // keep generating until valid
            timeTable = new String[6][8]; // reset timetable

            // subjectName -> faculty/labId mapping
            HashMap<String, String> hash = new HashMap<>();
            for (Faculty f : faculties) {
                hash.put(f.getSubjectName(), f.getFacultyId());
            }
            for (Lab l : labs) {
                hash.put(l.getSubjectName(), l.getLabId());
            }

            // ---------------- LAB ALLOCATION ----------------
            for (Lab lab : labs) {
                int totalLectures = 0;
                while (lab.getTotalLecturePerWeek() > totalLectures) {
                    int day = (int) (Math.random() * 6);
                    boolean alreadyInDay = false;

                    for (int k = 0; k < 8; k++) {
                        if ((lab.getSubjectName() + "_Lab").equals(timeTable[day][k])) {
                            alreadyInDay = true;
                            break;
                        }
                    }
                    if (alreadyInDay) continue;

                    boolean placed = false;
                    for (int j = 0; j < 7; j++) {
                        if (timeTable[day][j] == null && timeTable[day][j + 1] == null) {
                            timeTable[day][j] = lab.getSubjectName() + "_Lab";
                            timeTable[day][j + 1] = lab.getSubjectName() + "_Lab";
                            totalLectures += 2;
                            placed = true;
                            break;
                        }
                    }
                }
            }

            // ---------------- FACULTY ALLOCATION ----------------
            for (Faculty fac : faculties) {
                int totalLectures = 0;
                while (fac.getTotalLecturePerWeek() > totalLectures) {
                    int day = (int) (Math.random() * 6);
                    int lecturesToday = 0;

                    for (int k = 0; k < 8; k++) {
                        if (fac.getSubjectName().equals(timeTable[day][k])) {
                            lecturesToday++;
                        }
                    }
                    if (lecturesToday >= 3) continue;

                    boolean placed = false;
                    for (int j = 0; j < 8; j++) {
                        if (timeTable[day][j] == null) {
                            String subj = fac.getSubjectName();
                            boolean valid = true;

                            // Avoid 3 consecutive same subject
                            if (j >= 2 && subj.equals(timeTable[day][j - 1]) && subj.equals(timeTable[day][j - 2]))
                                valid = false;
                            if (j >= 1 && j < 7 && subj.equals(timeTable[day][j - 1]) && subj.equals(timeTable[day][j + 1]))
                                valid = false;
                            if (j < 6 && subj.equals(timeTable[day][j + 1]) && subj.equals(timeTable[day][j + 2]))
                                valid = false;

                            if (valid) {
                                timeTable[day][j] = subj;
                                totalLectures++;
                                placed = true;
                                break;
                            }
                        }
                    }
                }
            }

            // ---------------- VALIDATION ----------------
           // if (validateTimeTable(timeTable, faculties, labs)) {
                // save to DB finally
                for (int i = 0; i < timeTable.length; i++) {
                    for (int j = 0; j < timeTable[0].length; j++) {
                        if (timeTable[i][j] != null) {
                            String subj = timeTable[i][j];
                            String tableName = hash.get(subj.replace("_Lab", ""));
                            String sql = "INSERT INTO " + tableName + " (day, allotted) VALUES (?, ?)";
                            jdbcTemplate.update(sql, i + "," + j, className);
                        }
                    }
                }
                return timeTable; // success, return timetable
           // }
            // else loop again and regenerate
        }
    }

    // ---------------- VALIDATION FUNCTION ----------------
    private boolean validateTimeTable(String[][] timeTable, List<Faculty> faculties, List<Lab> labs) {
        // check DB for every slot faculty availability
        for (int i = 0; i < timeTable.length; i++) {
            for (int j = 0; j < timeTable[0].length; j++) {
                if (timeTable[i][j] != null) {
                    String subj = timeTable[i][j].replace("_Lab", "");
                    String facultyId = null;

                    for (Faculty f : faculties) {
                        if (f.getSubjectName().equals(subj)) {
                            facultyId = String.valueOf(f.getFacultyId());
                            break;
                        }
                    }
                    for (Lab l : labs) {
                        if (l.getSubjectName().equals(subj)) {
                            facultyId = String.valueOf(l.getLabId());
                            break;
                        }
                    }

                    if (facultyId != null) {
                        List<Map<String, Object>> data = facultyService.getData(facultyId);
                        for (Map<String, Object> row : data) {
                            String slot = row.get("day").toString();
                            if (slot.equals(i + "," + j)) {
                                // conflict found
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true; // no conflicts
    }
}
