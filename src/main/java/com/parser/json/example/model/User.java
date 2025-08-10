package com.parser.json.example.model;

import java.util.List;

public class User {
    private String name;
    private int age;
    private Address address;
    private List<Course> courses;
    private List<String> skills;
    private boolean isAdmin;

    public User() {
    }

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
