package bip.online.homework2.entity;

import java.util.Objects;

public class Employee {

    private String secondName;
    private String name;
    private String surname;
    private Double salary;
    private String department;

    public Employee(String surname, String name, String secondName, Double salary, String department) {
        this.secondName = secondName;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(secondName, employee.secondName) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondName, name, surname, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", secondName='" + secondName + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
