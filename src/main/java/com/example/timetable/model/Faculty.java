package com.example.timetable.model;

public class Faculty {
    private String facultyId;
    private String subjectName;
    private int totalLecturePerWeek;

    public Faculty() {}

    public Faculty(String facultyId, String subjectName, int totalLecturePerWeek) {
        this.facultyId = facultyId;
        this.subjectName = subjectName;
        this.totalLecturePerWeek = totalLecturePerWeek;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalLecturePerWeek() {
        return totalLecturePerWeek;
    }

    public void setTotalLecturePerWeek(int totalLecturePerWeek) {
        this.totalLecturePerWeek = totalLecturePerWeek;
    }
}
