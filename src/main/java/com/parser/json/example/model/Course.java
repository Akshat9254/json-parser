package com.parser.json.example.model;

public class Course {
    String name;
    int duration;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
