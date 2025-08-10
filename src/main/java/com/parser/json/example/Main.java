package com.parser.json.example;

import com.parser.json.core.parser.JsonParser;
import com.parser.json.example.model.User;
import com.parser.json.example.model.UserRecord;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                    "name": "John",
                    "age": 30,
                    "isAdmin": true,
                    "address": {
                        "city": "New York",
                        "country": "USA"
                    },
                    "courses": [
                        {"name": "Java", "duration": 3},
                        {"name": "Python", "duration": 2}
                    ],
                    "skills": ["Java", "Python"]
                }
                """;
        JsonParser parser = new JsonParser();
        UserRecord user = parser.parse(json, UserRecord.class);
//        User user = parser.parse(json, User.class);
        System.out.println(user);
    }
}
