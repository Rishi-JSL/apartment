package com.apartment.apartment.dao.impl;

import com.apartment.apartment.dao.RoleDao;
import com.apartment.apartment.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final static String GET_ID_FROM_ROLE = "SELECT ID FROM ROLES WHERE ROLE=?";
    private final static String INSERT_USER_ROLE_MAPPING = "INSERT INTO USER_ROLE_MAPPING (USER_ID,ROLE_ID) VALUES (?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public RoleDTO getIdFromRole(String role) {
        return jdbcTemplate.queryForObject(GET_ID_FROM_ROLE, new BeanPropertyRowMapper<>(RoleDTO.class), role);
    }

    @Override
    public void mapUserAndRole(int userId, int roleId) {
        jdbcTemplate.update(INSERT_USER_ROLE_MAPPING, userId, roleId);
    }
}
