package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudentControlerTest {

    @Test
    public void testStudentName() {

        Student student = new Student();
        student.setName("Amit");

        assertEquals("Amit", student.getName());
    }
}