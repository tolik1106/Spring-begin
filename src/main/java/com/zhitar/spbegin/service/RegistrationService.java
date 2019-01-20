package com.zhitar.spbegin.service;

import com.zhitar.spbegin.dto.RegistrationUserDTO;

public interface RegistrationService {

    boolean isUserExists(String login);

    enum RegistrationStatus{
        OK, VALIDATION_ERROR, DUPLICATE, DB_ERROR, SERVER_ERROR
    }

    RegistrationStatus register(RegistrationUserDTO userDTO);
}
