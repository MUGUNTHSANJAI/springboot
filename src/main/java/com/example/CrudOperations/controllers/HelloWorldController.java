import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {
    //Service layer
    @Autowired
    private HelloWorldService hws;

    //    @GetMapping("/hello")
//    public String hello() {
//       return hws.helloWorld();
//    }
//    @PostMapping("/")
//    public String post(){
//        return hws.postMethod();
//    }
//    @PutMapping("/")
//    public String put(){
//        return hws.putMethod();
//    }
//    @DeleteMapping("/")
//    public String delete(){
//        return hws.deleteMethod();
//    }
    @PostMapping("/employee")

    @PostMapping
    public String addEmployee(@RequestBody Employee e){
        hws.addEmployee(e);
        return "Employee Added Successfully";
    }

    @GetMapping("/employee")
    @GetMapping
    public List<Employee> getEmployees(){
        return hws.getAllEmployees();
    }

    @GetMapping("/{eid}")
    public Employee getEmployeeById(@PathVariable int eid){
        return hws.getEmployeeById(eid);
    }

    @DeleteMapping("/{eid}")
    public String deleteEmployee(@PathVariable int eid){
        return hws.deleteEmployeeById(eid);

    }

    @PutMapping("/{eid}")
    public String updateRecord(@RequestBody Employee employee){
        return hws.updateRecord(employee);
    }


}