package com.apartment.apartment.dao.impl;

import com.apartment.apartment.dao.ApartmentDao;
import com.apartment.apartment.entity.Apartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApartmentDaoImpl implements ApartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApartmentDaoImpl.class);

    public static final String INSERT_APARTMENT = "INSERT INTO APARTMENTS (NAME,OWNER_ID,PLOT_ID,DEPOSIT,RENT,MAINTENANCE,PER_UNIT_CHARGE_ELECTRICITY,PER_UNIT_CHARGE_WATER,DETAILS,BHK,LOCATION) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    public static final String FETCH_ALL_APARTMENTS = "SELECT ID,NAME,OWNER_ID,PLOT_ID,DEPOSIT,RENT,MAINTENANCE,PER_UNIT_CHARGE_ELECTRICITY,PER_UNIT_CHARGE_WATER,DETAILS,BHK,LOCATION,CREATED_AT,UPDATED_AT FROM APARTMENTS WHERE OWNER_ID=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long insertApartment(Apartment apartment) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(INSERT_APARTMENT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, apartment.getName());
                ps.setString(2, apartment.getOwnerId());
                ps.setString(3, apartment.getPlotId());
                ps.setString(4, apartment.getDeposit());
                ps.setString(5, apartment.getRent());
                ps.setString(6, apartment.getMaintenance());
                ps.setString(7, apartment.getPerUnitChargeElectricity());
                ps.setString(8, apartment.getPerUnitChargeWater());
                ps.setString(9, apartment.getDetails());
                ps.setString(10, apartment.getBhk());
                ps.setString(11, apartment.getLocation());
                return ps;
            }, keyHolder
        );
        return keyHolder.getKey().longValue();
    }

    @Override
    public List<Apartment> fetchAllApartments(String ownerId) {
        List<Apartment> apartments = new ArrayList<>();
        try {
            apartments = jdbcTemplate.query(FETCH_ALL_APARTMENTS, new BeanPropertyRowMapper<>(Apartment.class), ownerId);
        } catch (Exception e) {
            LOGGER.error("Exception here: ", e);
        }
        return apartments;
    }
}
