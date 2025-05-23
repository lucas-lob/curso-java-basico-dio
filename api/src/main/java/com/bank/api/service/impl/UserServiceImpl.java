package com.bank.api.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.bank.api.domain.models.User;
import com.bank.api.domain.repository.UserRepository;
import com.bank.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This account exists!");
        }

        return userRepository.save(userToCreate);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

}
