package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName() {
        Department department = new Department();
        department.setName("Engineering");
        departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
        employee.setDepartment(department);
        employeeRepository.save(employee);

        List<Employee> employees = employeeRepository.findByName("John Doe");
        assertThat(employees).hasSize(1).contains(employee);
    }

    @Test
    public void testFindByEmail() {
        Department department = new Department();
        department.setName("HR");
        departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setName("Jane Doe");
        employee.setEmail("jane.doe@example.com");
        employee.setDepartment(department);
        employeeRepository.save(employee);

        Optional<Employee> foundEmployee = employeeRepository.findByEmail("jane.doe@example.com");
        assertThat(foundEmployee).isPresent().contains(employee);
    }

    @Test
    public void testFindByDepartmentName() {
        Department department = new Department();
        department.setName("Sales");
        departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setName("Alice");
        employee.setEmail("alice@example.com");
        employee.setDepartment(department);
        employeeRepository.save(employee);

        List<Employee> employees = employeeRepository.findByDepartmentName("Sales");
        assertThat(employees).hasSize(1).contains(employee);
    }
}
