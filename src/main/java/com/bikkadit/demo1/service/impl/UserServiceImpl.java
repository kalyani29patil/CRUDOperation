package com.bikkadit.demo1.service.impl;

import com.bikkadit.demo1.model.User;
import com.bikkadit.demo1.repository.UserRepository;
import com.bikkadit.demo1.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

   @Autowired
   private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        User saveUser = userRepository.save(user);

        return saveUser;
    }

      //kalyani,24,developer
      //rahul,27,tester
    @Override
    public User updateUser(User user, Long userId) {

        User user1 = userRepository.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);


        return updatedUser;
    }

    @Override
    public User getSingleUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resourse not found on server!!" +userId));
        return user;

    }

//        Optional<User> user = userRepository.findById(userId);
//
//        if(user.isPresent()){
//            return user.get();
//        }else {
//
//        throw new NullPointerException("Resourse not found on server");
//    }
//    }




    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();


        return allUsers;
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resourse not found on server!!" + userId));
        userRepository.delete(user);
    }
}
