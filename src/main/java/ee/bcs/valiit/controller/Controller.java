package ee.bcs.valiit.controller;

import ee.bcs.valiit.tdoKlassid.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    public List<Employee> employeeList = new ArrayList<>();

    @GetMapping("test/hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl") String name, @RequestParam("action") String action) {
        return action + " " + name;
    }

/*    @GetMapping("employees")
    public List<Employee> employee() {
        Employee employee1 = new Employee();
        employee1.setName("Karin Kuusk");
        employee1.setAddress("Telliskivi 5");
        employee1.setID("Marketing");
        employee1.setEmploymentDate(2019);
        Employee employee2 = new Employee();
        employee2.setName("Liis Lumi");
        employee2.setAddress("Kuuse põik 6");
        employee2.setID("Finance");
        employee2.setEmploymentDate(2020);
        Employee employee3 = new Employee();
        employee3.setName("Tiina Tamm");
        employee3.setAddress("Laki tn 3");
        employee3.setID("Accounting");
        employee3.setEmploymentDate(2015);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        return employeeList;
    }*/


    @GetMapping("employees")
    public List<Employee> workersGet() {
        return employeeList;
    }

    @PostMapping("employees")
    public void workersPost(@RequestBody Employee employee) {
        employeeList.add(employee);
    }

    @GetMapping("employees/{index}")
    public Employee getEmployee(@PathVariable("index") int a){
        return employeeList.get(a);
    }

    @PutMapping("employees/{index}")
    public void updateWorker(@RequestBody Employee employee, @PathVariable("index") int a){
        employeeList.set(a,employee);
    }

    @DeleteMapping("employees/{index}")
    public void deleteEmpolyee(@PathVariable("index") int a){
        employeeList.remove(a);
    }






}




