package com.zhitar.spbegin.validation;

import com.zhitar.spbegin.dto.RegistrationUserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordTheSameValidator implements ConstraintValidator<PasswordTheSame, RegistrationUserDTO> {
    @Override
    public void initialize(PasswordTheSame constraintAnnotation) {

    }

    @Override
    public boolean isValid(RegistrationUserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        return userDTO.getPassword().equals(userDTO.getRePassword());
    }
}
