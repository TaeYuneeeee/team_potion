package com.example.swc_project;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Timetable_DB {
    private String Subject;

    public Timetable_DB(){
        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }

    public Timetable_DB(String Subject) {
        this.Subject = Subject;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
/*
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Time", Time);
        result.put("Week", Week);
        result.put("Subject", Subject);
        return result;
    }

 */
}
