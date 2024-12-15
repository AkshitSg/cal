package com.example.cla.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    int id;
    @Column(name="firstname")
    String firstName;
    @Column(name="lastname")
    String lastName;
    @Column(name="email_address")
    String email_add;

    public Student(){};
    public Student(String firstName, String lastName, String email_add) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email_add = email_add;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail_add() {
        return email_add;
    }

    public void setEmail_add(String email_add) {
        this.email_add = email_add;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email_add='" + email_add + '\'' +
                '}';
    }
}
