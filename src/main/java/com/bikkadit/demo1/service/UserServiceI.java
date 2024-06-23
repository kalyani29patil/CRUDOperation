package com.bikkadit.demo1.service;


import com.bikkadit.demo1.model.User;

import java.util.List;

public interface UserServiceI {
    //CRUDOperation

    //CREATE

    User createUser(User user);

    //UPDATE

    User updateUser(User user, Long userId);

    //GET single data

    User getSingleUser(Long userId) throws Exception;

    //GET all data

    List<User> getAllUsers();

    //DELETE

    void deleteUser(Long userId);
}
