package bip.online.homework2.Service;

import bip.online.homework2.entity.Employee;
import bip.online.homework2.exception.EmployeeAlreadyAddedException;
import bip.online.homework2.exception.EmployeeNotFoundException;
import bip.online.homework2.exception.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    private final static int count = 10;
    private Map<String, Employee> employees;

    public EmployeeService(Map<String, Employee> employees) {
        this.employees = employees;
    }

    private Optional<Employee> find(String employee) {
        return Optional.ofNullable(employees.get(employee));
    }

    public Employee search(String surname, String name) {
        return find((surname + name).toLowerCase()).orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee add(Employee e) {
        if (employees.size() < count) {
            if (StringUtils.isAlpha(e.getSurname())
                    && StringUtils.isAlpha(e.getName())
                    && StringUtils.isAlpha(e.getSecondName())) {
                if (find((e.getSurname().toLowerCase() + e.getName()).toLowerCase()).isEmpty()){
                    e.setName(StringUtils.capitalize(e.getName()));
                    e.setSecondName(StringUtils.capitalize(e.getSecondName()));
                    e.setSurname(StringUtils.capitalize(e.getSurname()));
                    employees.put((e.getSurname().toLowerCase() + e.getName()).toLowerCase(), e);
                }

                else
                    throw new EmployeeAlreadyAddedException();
            } else
                throw new EmployeeAlreadyAddedException();
        } else
            throw new EmployeeStorageIsFullException();
        return e;
    }

    public Employee remove(String firstName, String lastName) {
        Optional<Employee> employee = find((firstName + lastName).toLowerCase());
        if (employee.isEmpty())
            throw new EmployeeNotFoundException();
        else employees.remove((firstName + lastName).toLowerCase());
        return employee.get();
    }


    public List<Employee> getAll() {
        return employees.values().stream().toList();
    }
}
