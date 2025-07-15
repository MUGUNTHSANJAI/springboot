package com.example.Springbootfirstproject.Controller;
import com.example.Springbootfirstproject.Models.Student;
import com.example.Springbootfirstproject.Services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/student")
public class HelloWorldController {

    @Autowired
    private HelloWorldService sws;



//    @GetMapping("/hello")
//    public String hello()
//    {
//        return sws.hello();
//    }
//
//    @PostMapping("/hello")
//    public String postHello()
//    {
//        return sws.postHello();
//    }
//
//    @PutMapping("/hello")
//    public String PutMapping()
//    {
//        return sws.PutMapping();
//    }
//
//    @DeleteMapping("/hello")
//    public String DeleteMapping()
//    {
//        return  sws.Deletemapping();
//    }
//
//    @PostMapping("/")
//    public void SetArrayListvalues(@RequestBody Employee emp)
//    {
//        sws.Setvalues(emp);
//    }
//
//    @GetMapping("/")
//    public ArrayList<Employee> emp()
//    {
//        return sws.getEmp();
//    }

    //
//    @PutMapping("/")
//    public void ChangeEmployee(@RequestBody List< Employee> emp)
//    {
//        sws.ChnageDetails(emp);
//    }
//
//    @DeleteMapping("/")
//    public void DeleteEmployee(@RequestBody  Employee emp)
//    {
//        sws.DeleteEmployee(emp);
//    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<Student> getAllStudents()
    {
        return sws.getAllStudents();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public Student getStudentId(@PathVariable int id) {
        System.out.println(id);
        return sws.getStudentId(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        if(sws.addStudent(student))
        {
            return "Success";
        }
        return "Not Success";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public String updateStudent(@RequestBody Student student,@PathVariable int id) {
            if(sws.UpdateStudent(id,student))
            {
                return "Success";
            }
            return "Not Success";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public String deleteStudent(@RequestBody Student student) {
        if(sws.deleteStudent(student))
        {
            return "Success";
        }
        return "Not Success";

    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/name")
    public List<Student> getStudentsByname(@RequestParam String name){
        return sws.getStudentsByName(name);
    }

}
