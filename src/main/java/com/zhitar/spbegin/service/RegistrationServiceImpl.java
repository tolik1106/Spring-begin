package com.zhitar.spbegin.service;

import com.zhitar.spbegin.dao.IdeasDAO;
import com.zhitar.spbegin.dto.RegistrationUserDTO;
import com.zhitar.spbegin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private IdeasDAO dao;

    @Override
    @Transactional(readOnly = true)
    public boolean isUserExists(String login) {
        return dao.isUserExists(login);
    }

    @Override
    @Transactional
    public RegistrationStatus register(RegistrationUserDTO userDTO) {
        User user = new User();
        try {
            user.setEmail(userDTO.getLogin());
            String s = null;

            s = generateSalt(20);

            user.setSalt(s);
            byte[] hash = hash(s + userDTO.getPassword());
            user.setPassword(hash);
            boolean result = dao.registerUser(user);
            if (result) {
                return RegistrationStatus.OK;
            }
            return RegistrationStatus.DB_ERROR;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return RegistrationStatus.SERVER_ERROR;
        }
    }

    private byte[] hash(String fullPassword) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(fullPassword.getBytes());
        byte[] result = digest.digest();
        return result;
    }

    private String generateSalt(int i) throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[i];
        random.nextBytes(salt);
        return DatatypeConverter.printBase64Binary(salt);
    }
}
