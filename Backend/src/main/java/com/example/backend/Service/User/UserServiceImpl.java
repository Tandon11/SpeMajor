package com.example.backend.Service.User;

import com.example.backend.Model.User;
import com.example.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(String email) {
        return userRepository.findById(email);
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    public boolean checkUser(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean checkLogin(String email, String password) {
        if(checkUser(email)) {
            User user = getUser(email);
            if(user.getPassword().equals(password))
                return true;
            else
                return false;
        }
        else
            return false;
    }

}
