package com.site;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public static void createStudent(Student student) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }
    public static Student findStudentById(int id) {
        EntityManager em = getEntityManager();
        return em.find(Student.class, id);
    }
    public static Student findStudentByName (String studentName){
        EntityManager em = getEntityManager();
        return em.createQuery(
                        "SELECT s FROM Student s WHERE s.name = :name",
                        Student.class
                )
                .setParameter("name", studentName)
                .getSingleResult();
    }
    public static void updateStudentName(String newName, int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        student.setName(newName);
        em.getTransaction().commit();
    }
    public static void updateStudentNameAndTech(String newName, String newTech, int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        student.setName(newName);
        student.setTech(newTech);
        em.getTransaction().commit();
    }
    public static void deleteStudentById(int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        em.getTransaction().commit();
    }



    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Mohammed Ali");
        student.setTech("Python");
        createStudent(student);
        updateStudentNameAndTech("Kenenisa Bekele", "Rust", 1);
        Student fetchedStudentId = findStudentById(1);
        System.out.println("Fetched student by ID: " + fetchedStudentId);
        //deleteStudentById(2);
        Student fetchedStudentByName = findStudentByName("Mohammed Ali");
        System.out.println(" Fetched student by name: " + fetchedStudentByName);


    }
}
