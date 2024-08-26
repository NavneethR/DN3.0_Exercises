package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d WHERE d.name = :name")
    Optional<Department> findByName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:substring%")
    List<Department> findDepartmentsByNameContaining(@Param("substring") String substring);

    // Retrieve department data as projection
    List<DepartmentProjection> findAllProjectedBy();

    @Query("SELECT new com.example.employeemanagementsystem.dto.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findAllDepartmentDTOs();

    // Derived query methods
    Department findByName(String name);
}
