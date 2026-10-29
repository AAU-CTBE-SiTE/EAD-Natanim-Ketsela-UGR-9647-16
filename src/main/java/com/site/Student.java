package com.site;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;
    Student(int id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("constructor called!");

    }
    public void getDetails()  {
        System.out.println("Student details: " + this);
    }
}
