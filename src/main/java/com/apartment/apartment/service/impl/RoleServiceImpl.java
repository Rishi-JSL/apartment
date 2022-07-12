package com.apartment.apartment.service.impl;

import com.apartment.apartment.dao.RoleDao;
import com.apartment.apartment.dto.RoleDTO;
import com.apartment.apartment.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void mapUserAndRole(int userId) {
        RoleDTO roleDTO = roleDao.getIdFromRole("USER");
        roleDao.mapUserAndRole(userId, roleDTO.getId());
    }
}
