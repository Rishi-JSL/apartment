package com.apartment.apartment.dao.impl;

import com.apartment.apartment.dao.UserDao;
import com.apartment.apartment.dto.RoleDTO;
import com.apartment.apartment.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserDaoImpl implements UserDao {

    private final static String INSERT_USER = "INSERT INTO USERS (FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,STATUS) VALUES (?,?,?,?,?)";
    private final static String GET_USER_FROM_EMAIL = "SELECT ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,STATUS FROM USERS WHERE EMAIL=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertUser(UserDTO userDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, userDTO.getFirstName());
                    ps.setString(2, userDTO.getLastName());
                    ps.setString(3, userDTO.getEmail());
                    ps.setString(4, userDTO.getPassword());
                    ps.setString(5, userDTO.getStatus());
                    return ps;
                }, keyHolder
            );
        return keyHolder.getKey().intValue();
    }

    @Override
    public UserDTO getUserFromEmail(String email) {
        return jdbcTemplate.queryForObject(GET_USER_FROM_EMAIL, new BeanPropertyRowMapper<>(UserDTO.class), email);
    }
}
