package com.example.employeespringboot.controllers;

import com.example.employeespringboot.models.RegisterDetails;
import com.example.employeespringboot.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    EmployeeController employeeController;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRoute(){
        String result=employeeController.route();
        assertEquals("Welcome to SpringBoot Security",result);
    }
    @Test
    void testGetMethod(){
        RegisterDetails emp1 =new RegisterDetails();
        RegisterDetails emp2=new RegisterDetails();
        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails>result=employeeController.getMethod();
        assertEquals(2,result.size());
    }
}