package com.lekodevs.wonderbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekodevs.wonderbank.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);
    
    User findByUsername(String username);
}
