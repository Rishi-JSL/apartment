package com.apartment.apartment.service;

import com.apartment.apartment.dto.UserDTO;

public interface UserService {

    int insertUser(UserDTO userDTO);
    UserDTO getUserFromEmail(String email);
}
