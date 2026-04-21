package com.paypal.user_service.service;

import com.paypal.user_service.dto.SignupRequest;
import com.paypal.user_service.entity.User;


import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(SignupRequest newUser);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    boolean existWithEmail(String email);
}
