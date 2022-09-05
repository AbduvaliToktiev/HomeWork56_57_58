package com.example.homework56_57_58.service;

import com.example.homework56_57_58.dao.UserRepository;
import com.example.homework56_57_58.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registrationUser(User user) {
        userRepository.registrationUser(user);
    }
}
