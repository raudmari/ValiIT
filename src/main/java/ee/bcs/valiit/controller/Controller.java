package ee.bcs.valiit.controller;

import ee.bcs.valiit.tdoKlassid.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("sample/hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl")String name, @RequestParam("action") String action){
        return action + " " + name;
    }

    @GetMapping("/employee/")
    public List<Employee> employee(){
        Employee employee1 = new Employee();
        employee1.setName("Karin Kuusk");
        employee1.setAddress("Telliskivi 5");
        employee1.setID("12WD");
        employee1.setEmploymentDate(2019);
        Employee employee2 = new Employee();
        employee2.setName("Liis Lumi");
        employee2.setAddress("Kuuse põik 6");
        employee2.setID("IY543");
        employee2.setEmploymentDate(2020);
        Employee employee3 = new Employee();
        employee3.setName("Tiina Tamm");
        employee3.setAddress("Laki tn 3");
        employee3.setID("OL89");
        employee3.setEmploymentDate(2015);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        return employeeList;
    }



}
