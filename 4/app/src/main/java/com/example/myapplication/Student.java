package com.example.myapplication;

// Helper class to represent each student record
public class Student {
    private String rollNo;
    private String name;
    private String email;
    private String course;

    public Student(String rollNo, String name, String email, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
}
