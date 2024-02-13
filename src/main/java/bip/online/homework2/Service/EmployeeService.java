package bip.online.homework2.Service;

import bip.online.homework2.entity.Employee;
import bip.online.homework2.exception.EmployeeAlreadyAddedException;
import bip.online.homework2.exception.EmployeeNotFoundException;
import bip.online.homework2.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final static int count = 10;
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    private Employee find(Employee employee) {
        Employee result = null;
        for (Employee e : employees) {
            if (e.equals(employee)) {
                result = e;
                break;
            }
        }
        return result;
    }

    public Employee search(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (find(employee) == null)
            throw new EmployeeNotFoundException();
        return employee;
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < count) {
            if (find(employee) == null)
                employees.add(employee);
            else
                throw new EmployeeAlreadyAddedException();
        } else
            throw new EmployeeStorageIsFullException();
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = find(new Employee(firstName, lastName));
        if (employee == null)
            throw new EmployeeNotFoundException();
        else employees.remove(employee);
        return employee;
    }


    public List<Employee> getAll() {
        return employees;
    }
}
