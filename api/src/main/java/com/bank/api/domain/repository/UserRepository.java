package com.bank.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.api.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
