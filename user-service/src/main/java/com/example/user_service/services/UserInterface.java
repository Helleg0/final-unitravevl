package com.example.user_service.services;


import com.example.user_service.model.entities.User;

import java.util.List;

public interface UserInterface {
    public List<User> getAllUsers();
    public User addUser(User user);
    public User deleteUser(User user);
}
