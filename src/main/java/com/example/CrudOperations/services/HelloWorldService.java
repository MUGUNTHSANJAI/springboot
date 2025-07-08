public class HelloWorldService {
            new Employee(1, "Prasanth", "Trainer"),
            new Employee(2, "Yuvaraj", "Faculty")
    ));

    //    public String helloWorld(){
//        return "Hello World";
//    }
//
//    public String postMethod(){
//        return "This is Post Method";
//    }
//
//    public String putMethod(){
//        return "This is Put Method";
//    }
//
//    public String deleteMethod(){
//        return "This is Delete Method";
//    }
    public void addEmployee(Employee e) {
        emp.add(e);
    }

    public List<Employee> getAllEmployees() {
        return emp;
    }

    public Employee getEmployeeById(int eid){
        for(Employee e:emp){
            if(e.getEid() == eid){
                return e;
            }
        }
        return null;
    }

    public String deleteEmployeeById(int eid) {
        int ind = 0;
        boolean flag = false;
        for(int i=0;i<emp.size();i++){
            if(eid == emp.get(i).getEid()){
                System.out.println("Emp_ID: "+ emp.get(i).getEid()+emp.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if(flag){
            emp.remove(ind);
            return "Deleted Employee Successfully!!!";
        }
        else{
            return "Employee not found";
        }
    }

    public String updateRecord(Employee e){
        int ind = 0;
        boolean flag = false;
        for(int i=0;i<emp.size();i++){
            if(e.getEid() == emp.get(i).getEid()){
                System.out.println("Emp_ID: "+ emp.get(i).getEid()+emp.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if(flag){
            emp.set(ind,e);
            return "Updated Employee Successfully";
        }
        else{
            return "Employee not found";
        }
    }
}