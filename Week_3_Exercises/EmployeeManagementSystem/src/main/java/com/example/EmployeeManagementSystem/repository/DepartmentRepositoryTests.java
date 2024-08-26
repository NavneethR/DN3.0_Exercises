package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DepartmentRepositoryTests {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName() {
        Department department = new Department();
        department.setName("Marketing");
        departmentRepository.save(department);

        Optional<Department> foundDepartment = departmentRepository.findByName("Marketing");
        assertThat(foundDepartment).isPresent().contains(department);
    }
}
