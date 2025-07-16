package com.example.employeespringboot.services;


import com.example.employeespringboot.models.RegisterDetails;
import com.example.employeespringboot.repository.RegisterDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {
    @Mock
    RegisterDetailsRepository registerDetailsRepository;

    @InjectMocks
    EmployeeService employeeService;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetMethod(){
        RegisterDetails emp1=new RegisterDetails();
        RegisterDetails emp2=new RegisterDetails();
        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result= employeeService.getMethod();
        System.out.println(result);
        assertEquals(2,result.size());

    }


}