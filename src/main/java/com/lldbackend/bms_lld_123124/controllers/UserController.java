package com.lldbackend.bms_lld_123124.controllers;

import com.lldbackend.bms_lld_123124.dtos.DTOResponseStatus;
import com.lldbackend.bms_lld_123124.dtos.UserRequestDTO;
import com.lldbackend.bms_lld_123124.dtos.UserResponseDTO;
import com.lldbackend.bms_lld_123124.exceptions.UserExistsException;
import com.lldbackend.bms_lld_123124.models.User;
import com.lldbackend.bms_lld_123124.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {
    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        User user;
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        try{
            user = userService.createUser(
                    userRequestDTO.getUsername(),
                    userRequestDTO.getPassword(),
                    userRequestDTO.getFirstName(),
                    userRequestDTO.getLastName()
            );
            userResponseDTO.setUsername(user.getUserName());
            userResponseDTO.setStatus(DTOResponseStatus.SUCCESS);
            userResponseDTO.setMessage("User Saved Successfully");

        }catch (UserExistsException e){
            userResponseDTO.setStatus(DTOResponseStatus.ERROR);
            userResponseDTO.setMessage(e.getMessage());
        }
        return userResponseDTO;
    }

    public UserResponseDTO loginUser(UserRequestDTO userRequestDTO){
        return null;
    }

    public UserResponseDTO logoutUser(){
        return null;
    }
}
