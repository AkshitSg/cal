package com.example.cla.Dao.impl;

import com.example.cla.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDao implements com.example.cla.Dao.StudentDao {
    public EntityManager entityManager;
    @Autowired
    public StudentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }
    @Override
    public Student findById(Integer studentid) {
        return entityManager.find(Student.class,studentid);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> allStudents=theQuery.getResultList();
        return allStudents;
    }

    @Override
    public List<Student> findByLastName(String lastname) {
        TypedQuery theQuery=entityManager.createQuery
                ("SELECT s FROM Student s WHERE lastName=:theLastName", Student.class);
        theQuery.setParameter("theLastName",lastname);
        return theQuery.getResultList();
    }
}
