package com.apartment.apartment.dao;

import com.apartment.apartment.dto.UserDTO;

public interface UserDao {

    int insertUser(UserDTO userDTO);
    UserDTO getUserFromEmail(String email);
}
