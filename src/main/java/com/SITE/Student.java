package com.SITE;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String tech;

    public Student () {

    }

    public String getName() {
        return this.name;
    }

    public int getId (){
        return this.id;
    }

    public int getAge () {
        return this.age;
    }

    public void setName( String name) {
        this.name = name;
    }
    public void setTech(String tech) {
        this.tech = tech;
    }
    public void setAge (int age) {
        this.age = age;
    }
    public String toString() {
        return "id=" + id
                + ", name='" + name + '\''
                + ", age=" + age ;
    }


}
