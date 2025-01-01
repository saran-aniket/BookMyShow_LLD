package com.lldbackend.bms_lld_123124.services;

import com.lldbackend.bms_lld_123124.exceptions.UserExistsException;
import com.lldbackend.bms_lld_123124.models.User;
import com.lldbackend.bms_lld_123124.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User createUser(String userName, String password, String firstName, String lastName) throws UserExistsException {
        Optional<User> userList = findAllUsersByUserName(userName);
        User savedUser;
        if (userList.isPresent()) {
            throw new UserExistsException();
        }else{
            User user = new User();
            user.setUserName(userName);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setFirstName(firstName);
            user.setLastName(lastName);
            savedUser = this.userRepository.save(user);
        }
        return savedUser;
    }

    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    public void deleteUser(User user) {
        String userName = user.getUserName();
        this.userRepository.deleteUserByUserName(userName);
    }

    public Optional<User> findAllUsersByUserName(String userName){
        return this.userRepository.findByUserName(userName);
    }
}
