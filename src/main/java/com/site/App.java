package com.site;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student1 =  context.getBean(Student.class);
        Student student2 =  context.getBean(Student.class);
        System.out.println(student1 == student2);
        student1.setName("John Doe");
        student2.getDetails();

    }
}
