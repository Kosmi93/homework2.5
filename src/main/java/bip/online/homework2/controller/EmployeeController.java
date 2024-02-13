package bip.online.homework2.controller;

import bip.online.homework2.Service.EmployeeService;
import bip.online.homework2.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private  final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName){
        return service.add(firstName,lastName);
    }


    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName){
        return service.remove( firstName,lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName){
        return service.search(firstName,lastName);
    }

    @GetMapping("/all")
    public List<Employee> all(){
        return service.getAll();
    }

}
