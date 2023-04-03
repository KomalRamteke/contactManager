package com.example.phonelist.service;

import java.util.List;

import com.example.phonelist.entity.User;

public interface UserService {

    List<User> getByEmailUsers(String email);
    List<User> getByPasswordUsers(String password);
}
