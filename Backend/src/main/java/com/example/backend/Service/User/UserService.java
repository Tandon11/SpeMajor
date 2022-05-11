package com.example.backend.Service.User;

import com.example.backend.Model.User;

import java.util.List;

public interface UserService {
    public List<User> listAllUser();
    public void saveUser(User user);
    public User getUser(String email);
    public void deleteUser(String email);
    public boolean checkUser(String email);
    public boolean checkLogin(String email, String password);
}
