package com.apartment.apartment.dao;

import com.apartment.apartment.dto.RoleDTO;

public interface RoleDao {

    RoleDTO getIdFromRole(String role);
    void mapUserAndRole(int userId, int roleId);
}
