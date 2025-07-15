package com.example.Springbootfirstproject.Services;
import com.example.Springbootfirstproject.Models.Employee;
import com.example.Springbootfirstproject.Models.Student;
import com.example.Springbootfirstproject.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Service

public class HelloWorldService {

////    Employee ----------------------------------------------------------------------------->
//    ArrayList<Employee> l=new ArrayList<>(Arrays.asList
//            (new Employee(1,"SUMO","doctor","500"),new Employee(2,"abc","def","")));
//
//    public ArrayList<Employee>getEmp()
//    {
//        return l;
//    }
//    public void Setvalues(Employee emp)
//    {
//        l.add(emp);
//    }
//
//    public void ChnageDetails(List<Employee> emp) {
//        for(int i=0;i<l.size();i++)
//        {
//            if(l.get(i).getEmpid()== emp.get(0).getEmpid())
//            {
//                l.set(i,emp.get(1));
//            }
//        }
//    }
//    public void DeleteEmployee(Employee emp)
//    {
//
//        l.remove(emp);
//    }

//    Student----------------------------------------->
//    ArrayList<Student> st=new ArrayList<>(Arrays.asList
//        (new Student(1,"Sharan","ECE"),new Student(2,"Danista","CSE")));

////    Hello example-------------------------------------------------------->
//    public String  hello() {
//        return "hello from GetMapping";
//    }
//
//    public String postHello() {
//        return "hello from postHello";
//    }
//
//    public String PutMapping() {
//        return "Hello from PutMapping";
//    }
//
//    public String Deletemapping() {
//        return "Hello From DeleteMapping";
//    }

    @Autowired
    StudentRepo studentRepo;

    public Student getStudentId(int StId)
    {
        return  studentRepo.findById(StId).orElseThrow(() -> new RuntimeException("Not found"));

    }


    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public boolean addStudent(Student student) {
        studentRepo.save(student);
        return true;
    }

    public boolean UpdateStudent(int  id, Student student) {
        Student temp = studentRepo.findById(id).orElseThrow();
        temp.setName(student.getName());
        temp.setDept(student.getDept());
        studentRepo.save(temp);
        return true;
    }

    public boolean deleteStudent(Student student) {
        studentRepo.delete(student);
        return true;
    }


    public List<Student> getStudentsByName(String name) {
        return studentRepo.findByName(name);
    }
}
