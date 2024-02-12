package com.cyberoctet.training.demo.vulnerable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Employee {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String logEmployee(String name) {
        String sql = "SELECT * from employee where name = '" + name + "'";

        jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("name") + " " + rs.getString("comment"));

        return "Employee Logged";
    }
}