package com.example.demo;

public class Student {
    private String name;
    private int rollno;

    public void setName(String name) {
        this.name = name;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public String getName() {
        return name;
    }
    public int getRollno() {
        return rollno;
    }

    public void details() {
        System.out.println("Student{" + name + ", " + rollno + "}");
    }
}
