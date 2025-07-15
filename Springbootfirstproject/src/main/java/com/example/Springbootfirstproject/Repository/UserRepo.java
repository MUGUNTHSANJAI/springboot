package com.example.Springbootfirstproject.Repository;

import com.example.Springbootfirstproject.Models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<RegisterDetails,Integer> {
    RegisterDetails findByEmail(String email);

}
