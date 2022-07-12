package com.apartment.apartment.dao.impl;

import com.apartment.apartment.dao.PlotDao;
import com.apartment.apartment.entity.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlotDaoImpl implements PlotDao {

    private final static String GET_PLOT_FROM_NAME = "SELECT ID,LOCATION,NAME,APARTMENT_ID,CREATED_AT,UPDATED_AT FROM PLOTS WHERE NAME=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Plot getPlotFromPlotName(String plotName) {
        return jdbcTemplate.queryForObject(GET_PLOT_FROM_NAME, new BeanPropertyRowMapper<>(Plot.class), plotName);
    }
}
