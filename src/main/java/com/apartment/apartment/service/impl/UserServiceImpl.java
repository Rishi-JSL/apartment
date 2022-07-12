package com.apartment.apartment.service.impl;

import com.apartment.apartment.constants.Status;
import com.apartment.apartment.dao.UserDao;
import com.apartment.apartment.dto.UserDTO;
import com.apartment.apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public int insertUser(UserDTO userDTO) {
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userDTO.setStatus(Status.REGISTERED.name());
        return userDao.insertUser(userDTO);
    }

    @Override
    public UserDTO getUserFromEmail(String email) {
        return userDao.getUserFromEmail(email);
    }
}
