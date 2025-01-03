package com.lldbackend.bms_lld_123124;

import com.lldbackend.bms_lld_123124.controllers.UserController;
import com.lldbackend.bms_lld_123124.dtos.UserRequestDTO;
import com.lldbackend.bms_lld_123124.dtos.UserResponseDTO;
import com.lldbackend.bms_lld_123124.exceptions.UserExistsException;
import com.lldbackend.bms_lld_123124.models.User;
import com.lldbackend.bms_lld_123124.repositories.UserRepository;
import com.lldbackend.bms_lld_123124.services.RandomStringGeneratorService;
import com.lldbackend.bms_lld_123124.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BmsLld123124ApplicationTests {
    @Autowired
    UserController userController;
    @Autowired
    UserService userService;
    @Autowired
    RandomStringGeneratorService randomStringGeneratorService;
    @Test
    void testJPALifecycleEvents() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setUserName("user" + i);
            user.setPassword("password" + i);
            user.setFirstName("first" + i);
            user.setLastName("last" + i);
//            userService.createUser(user);
        }
    }

    @Test
    void testUserRegisterUser(){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUsername("ichikuro@jhg.com");
        userRequestDTO.setFirstName("Ichigo");
        userRequestDTO.setLastName("Kurosaki");
        userRequestDTO.setPassword("asdj23123");
        UserResponseDTO userResponseDTO = userController.registerUser(userRequestDTO);
        System.out.println(userResponseDTO.getStatus());
        System.out.println(userResponseDTO.getMessage());
        System.out.println(userResponseDTO.getUsername());
    }

    @Test
    void randomStringGenerator(){
        System.out.println(randomStringGeneratorService.generateRandomString(10));
    }

}
