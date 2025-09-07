package com.example.timetable.dto;

import com.example.timetable.model.Faculty;
import com.example.timetable.model.Lab;
import java.util.List;

public class TimeTableRequest {
    private String classRoom;
    private List<Faculty> faculties;
    private List<Lab> labs;

    public List<Faculty> getFaculties() { return faculties; }
    public void setFaculties(List<Faculty> faculties) { this.faculties = faculties; }

    public List<Lab> getLabs() { return labs; }
    public void setLabs(List<Lab> labs) { this.labs = labs; }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
