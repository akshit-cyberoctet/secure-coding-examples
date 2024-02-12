package com.cyberoctet.training.demo.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Employee {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String logEmployee(String name) {
        // Prevent SQL Injection by using prepared statement
        String sql = "SELECT * from employee where name = ?";

        jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("name") + " " + rs.getString("comment"), name);

        return "Employee Safely Logged";
    }
}

// You can also use Spring Data libraries to prevent SQL Injection instead of raw SQL statement.