package com.example.student.model;

public class Student {
    private long rollno;
    private String name;
    private String fatherName;
    private String motherName;

    public Student() {
    }
    public Student(long rollno, String name, String fatherName, String motherName) {
        this.rollno = rollno;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
    }

    public long getRollno() {
        return rollno;
    }

    public void setRollno(long rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
