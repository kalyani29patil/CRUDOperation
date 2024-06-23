package com.bikkadit.demo1.controller;


import com.bikkadit.demo1.model.User;
import com.bikkadit.demo1.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @PostMapping("/users")
    public ResponseEntity<User>  createUser(@RequestBody User user){
        User saveduser = userServiceI.createUser(user);
        return new ResponseEntity<>(saveduser, HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userServiceI.getAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {
        User user = userServiceI.getSingleUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
        User updatedUser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);


    }
    //@pathvariable= pass single data     /,/
    //@requestBody=whole object
    //@Requestparam=key-value pair=for paggination and sorting    ?,&

    @DeleteMapping("users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>( "Resource deleted succesfully", HttpStatus.OK);


    }
}
