package com.example.cla.Dao.impl;

import com.example.cla.Entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
