package bip.online.homework2.controller;

import bip.online.homework2.Service.DepartmentService;
import bip.online.homework2.entity.Employee;
import bip.online.homework2.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam String departmentId) {

        return service.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam String departmentId) {
        return service.minSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<String,List<Employee>> allDepartment() {

        // return departmentId.equals("default")?service.getAll():service.getByDepartment(departmentId);
        return  service.getAll() ;
    }
    @GetMapping("/all-{id}")
    public List<Employee> findByDepartment(@PathVariable String id) {

         return service.getByDepartment(id);

    }

}
