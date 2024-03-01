package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName(String name) {
        return name;
    }
    public int getAge(int age) {
        return age;
    }

    public void details() {
        System.out.println("Person{" + name + ", " + age + "}");
    }
}
