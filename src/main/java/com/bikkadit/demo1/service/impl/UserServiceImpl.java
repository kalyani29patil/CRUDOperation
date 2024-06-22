package com.bikkadit.demo1.service.impl;

import com.bikkadit.demo1.model.User;
import com.bikkadit.demo1.repository.UserRepository;
import com.bikkadit.demo1.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserServiceI {

   @Autowired
   private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        User saveUser = userRepository.save(user);

        return saveUser;
    }

    @Override
    public User updateUser(User user, Long userId) {




        return null;
    }

    @Override
    public User getSingleUser(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
