package com.example.backend.Controller;

import com.example.backend.Model.User;
import com.example.backend.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listUsers")
    public List<User> listAll() {
        return userService.listAllUser();
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        try{
            User user = userService.getUser(email);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/getname/{email}")
    public String getUserFullname(@PathVariable String email) {
        String mail = userService.getUser(email).getFullname();
        return mail;
    }

    @DeleteMapping("/user/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }

    @PutMapping("user/{email}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String email) {
        try {
            User existUser = userService.getUser(email);
            System.out.print(existUser);
            userService.saveUser(user);
            return new ResponseEntity<User>(HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("user/login")
    public boolean check(@RequestBody User user) {
        return userService.checkLogin(user.getEmail(), user.getPassword());
    }

    @PostMapping("/user/signup")
    public ResponseEntity<Boolean> addUser(@RequestBody User user) {
        if(userService.checkUser(user.getEmail()) == false) {
            userService.saveUser(user);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        else
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }

}
