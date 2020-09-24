package com.pocmongodb.demo.service;

import com.pocmongodb.demo.model.User;
import com.pocmongodb.demo.model.UserGroupAge;
import com.pocmongodb.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAllByRoleName(String roleName, String roleDesc) {
        return userRepository.findAllDataByRole(roleName, roleDesc);
    }

    public Optional<User> findUserById(String Id) {
        return userRepository.findById(Id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createMultiUser(List<User> user) {
        return userRepository.saveAll(user);
    }

    public boolean deleteUserById(String Id) {
        boolean isSuccess = false;
        try {
            userRepository.deleteById(Id);
            isSuccess = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public List<UserGroupAge> groupAge() {
        return userRepository.groupAge();
    }
}
