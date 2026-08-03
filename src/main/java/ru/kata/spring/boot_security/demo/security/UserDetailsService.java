package ru.kata.spring.boot_security.demo.security;

public class UserDetailsService implements UserDetails {
    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }
}
