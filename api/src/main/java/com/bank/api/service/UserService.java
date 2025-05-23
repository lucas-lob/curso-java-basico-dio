package com.bank.api.service;

import com.bank.api.domain.models.User;

public interface UserService {
    User findById(Long id);

    Iterable<User> findAll();

    User create(User userToCreate);
}
