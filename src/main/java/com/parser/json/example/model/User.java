package com.parser.json.example.model;

import java.util.List;

public class User {
    String name;
    int age;
    Address address;
    List<Course> courses;
    List<String> skills;
    boolean isAdmin;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", courses=" + courses +
                ", skills=" + skills +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
