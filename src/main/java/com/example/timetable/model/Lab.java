package com.example.timetable.model;

public class Lab {
    private String labId;
    private String subjectName;
    private int totalLecturePerWeek;

    public Lab() {}

    public Lab(String labId, String subjectName, int totalLecturePerWeek) {
        this.labId = labId;
        this.subjectName = subjectName;
        this.totalLecturePerWeek = totalLecturePerWeek;
    }

    // getters & setters


    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
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
