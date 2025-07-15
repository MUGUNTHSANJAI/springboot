package com.example.Springbootfirstproject.Controller;

import com.example.Springbootfirstproject.Models.RegisterDetails;
import com.example.Springbootfirstproject.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    @Autowired
    private RegisterService uds;

    @GetMapping
    public List<RegisterDetails> getUserDetails() {
        return uds.getAllUser();
    }

    @GetMapping("{id}")
    public RegisterDetails getUserDetails(@PathVariable int id) {
        return uds.findById(id);
    }

    @PostMapping("/register")
    public String addUser(@RequestBody RegisterDetails registerDetails) {
        if(uds.AddUser(registerDetails))
        {
            return "User Registered Successfully";
        }
        return "Registration Failed";
    }

    @GetMapping("/login")
    public String login(@RequestBody RegisterDetails registerDetails) {
        if(uds.Authenticate(registerDetails)) {
            return "Login successful";
        }
        return "Login Unsuccessful";
        }

    @DeleteMapping()
    public String deleteUser(@RequestBody RegisterDetails registerDetails) {
        {
            if(uds.delete(registerDetails))
            {
                return "Success";
            }
            return "Fail";
        }
    }
    @GetMapping("/useronly")
            public List <RegisterDetails> getAllUser(){
        return uds.getAllUserOnly();
    }
    {

    }
    @PutMapping("{id}")
    public String updateUser(@PathVariable int id, @RequestBody RegisterDetails registerDetails) {
        if(uds.update(id, registerDetails))
        {
            return "Success";
        }
        return "Fail";
    }



}
