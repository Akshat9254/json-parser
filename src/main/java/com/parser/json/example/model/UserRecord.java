package com.parser.json.example.model;

import java.util.List;

public record UserRecord(
        String name,
        int age,
        Address address,
        List<Course> courses,
        List<String> skills,
        boolean isAdmin
) {
}
