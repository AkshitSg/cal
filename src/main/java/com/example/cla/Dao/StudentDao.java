package com.example.cla.Dao;

import com.example.cla.Entity.Student;
import java.util.*;

public interface StudentDao {
    public Student save(Student student); // create
    public Student findById(Integer studentid); // read
    public List<Student> findAll();
    public List<Student> findByLastName(String lastname);
}
