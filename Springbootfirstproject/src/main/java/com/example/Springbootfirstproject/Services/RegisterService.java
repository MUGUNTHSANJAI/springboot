package com.example.Springbootfirstproject.Services;

import com.example.Springbootfirstproject.Models.RegisterDetails;
import com.example.Springbootfirstproject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RegisterService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<RegisterDetails> getAllUser() {
        return userRepo.findAll();
    }

    public RegisterDetails findById(int id) {
        RegisterDetails registerDetails = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return registerDetails;
    }

    public boolean AddUser(RegisterDetails registerDetails) {

        RegisterDetails resgister=new RegisterDetails();
        resgister.setDob(registerDetails.getDob());
        resgister.setEmpid(registerDetails.getEmpid());
        resgister.setEname(registerDetails.getEname());
        resgister.setRole(registerDetails.getRole());
        resgister.setEmail(registerDetails.getEmail());
        resgister.setPassword(passwordEncoder.encode(registerDetails.getPassword()));
        userRepo.save(resgister);
        return true;
    }

    public boolean delete(RegisterDetails registerDetails) {
        userRepo.deleteById(registerDetails.getEmpid());
        return true;
    }

    public boolean update(int id, RegisterDetails registerDetails) {
        userRepo.save(registerDetails);
        return true;
    }


    public boolean Authenticate(RegisterDetails registerDetails) {
        RegisterDetails rd=userRepo.findByEmail(registerDetails.getEmail());
        if(rd!=null) {
             if(passwordEncoder.matches(registerDetails.getPassword(),rd.getPassword())) {
                 return true;
             }

        }
        return false;
    }

    public List<RegisterDetails> getAllUserOnly() {
        List<RegisterDetails> rs=userRepo.findAll();
        List<RegisterDetails> result = new ArrayList<>(List.of());
        for(int i=0;i<rs.size();i++) {
            if(rs.get(i).getRole().equals("USER")) {
                result.add(rs.get(i));
            }
        }
        return result;
    }
}
