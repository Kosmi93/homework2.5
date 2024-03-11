package bip.online.homework2.controller;

import bip.online.homework2.Service.EmployeeService;
import bip.online.homework2.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String surname,
                        @RequestParam String name,
                        @RequestParam String secondName,
                        @RequestParam Double salary,
                        @RequestParam String department) {
        return service.add(new Employee(surname, name, secondName, salary, department));
    }


    @GetMapping("/remove")
    public Employee remove(@RequestParam String surname,
                           @RequestParam String name) {
        return service.remove(surname, name);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String surname,
                         @RequestParam String name) {
        return service.search(surname, name);
    }

    @GetMapping("/all")
    public List<Employee> all() {
        return service.getAll();
    }

}
