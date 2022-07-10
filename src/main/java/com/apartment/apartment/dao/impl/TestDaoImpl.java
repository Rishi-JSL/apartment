package com.apartment.apartment.dao.impl;

import com.apartment.apartment.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void put() {
        jdbcTemplate.update("INSERT INTO TEST (ID) VALUES (?)", 1);
    }

    @Override
    public String get() {
        return jdbcTemplate.queryForObject("SELECT * FROM TEST WHERE ID=?", String.class, 1);
    }
}
