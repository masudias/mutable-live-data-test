package com.example.livedata;

public class User {

    private String name;

    private User() {
    }

    public String getName() {
        return name;
    }

    public static class UserBuilder {
        private User user;

        public UserBuilder() {
            user = new User();
        }

        public UserBuilder withName(String name) {
            user.name = name;
            return this;
        }

        public User build() {
            return user;
        }
    }
}