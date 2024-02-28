package bip.online.homework2.Service;

import bip.online.homework2.entity.Employee;
import bip.online.homework2.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService service;

    public DepartmentService(EmployeeService service) {
        this.service = service;
    }
    public List<Employee> getAll(){
        return service.getAll().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    public List<Employee> getByDepartment(String departmentId) {
        return service.getAll().stream()
                .filter(e->e.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    public Employee minSalary(String departmentId) {
        return service.getAll().stream().filter(e->e.getDepartment().equals(departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee maxSalary(String departmentId) {
        return service.getAll().stream().filter(e->e.getDepartment().equals(departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
}
