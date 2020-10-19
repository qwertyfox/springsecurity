package com.springsecurity.artifact1.users;

public class Student {

    private final int student_id;
    private final String name;

    public Student(int student_id, String name) {
        this.student_id = student_id;
        this.name = name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }
}
