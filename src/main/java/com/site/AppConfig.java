package com.site;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

@Configuration
public class AppConfig {
    @Bean
    public Address address() {
        Address address = new Address();
        address.setCity("Addis Ababa");
        address.setCountry("Ethiopia");

        return address;
    }
    @Bean
    public Subject java() {
        Subject subject = new Subject();
        subject.setSubjectName("Java");

        return subject;
    }

    @Bean
    public Subject math() {
        Subject subject = new Subject();
        subject.setSubjectName("Mathematics");

        return subject;
    }
    @Bean(name ="Student")
    @Scope("prototype")

    public Student student (Address address, @Qualifier("java") Subject java,  @Qualifier("math")Subject math){
        Student student = new Student();
        student.setName("Mohammed Ali");
        student.setAge(60);
        student.setId(1);
        student.setAddress(address);
        student.setSubjects(Arrays.asList(math, java));

        return student;
    }

}
