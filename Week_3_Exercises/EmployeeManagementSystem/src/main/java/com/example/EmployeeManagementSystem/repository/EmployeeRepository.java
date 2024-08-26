package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Paginated query to get all employees
    Page<Employee> findAll(Pageable pageable);

    // Paginated and sorted query to find employees by name
    Page<Employee> findByNameContaining(String name, Pageable pageable);

    // Paginated and sorted query to find employees by department name
    Page<Employee> findByDepartmentNameContaining(String departmentName, Pageable pageable);

    // Retrieve employee data as projection
    List<EmployeeProjection> findAllProjectedBy();

    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();

    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email) FROM Employee e WHERE e.department.name = :departmentName")
    List<EmployeeDTO> findEmployeeDTOsByDepartmentName(@Param("departmentName") String departmentName);

    // Derived query methods
    Employee findByEmail(String email);
}
