package com.example.demo;

public class Doctor {
    private String qualification = "MBBS";
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void assist() {
        System.out.println("Doctor is assisting!");
    }
}
