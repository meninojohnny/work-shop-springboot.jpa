package com.johnny.teste.service;

import com.johnny.teste.entities.User;
import com.johnny.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long userId) {
        Optional<User> obj = userRepository.findById(userId);
        return obj.get();
    }

}
