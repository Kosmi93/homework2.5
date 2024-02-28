package bip.online.homework2.controller;

import bip.online.homework2.Service.DepartmentService;
import bip.online.homework2.entity.Employee;
import bip.online.homework2.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam String departmentId){

        return service.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam String departmentId){
        return service.minSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> allDepartment(@RequestParam(defaultValue = "default") String departmentId){

        return departmentId.equals("default")?service.getAll():service.getByDepartment(departmentId);
    }

}
