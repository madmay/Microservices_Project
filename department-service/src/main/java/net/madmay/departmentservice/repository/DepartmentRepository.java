package net.madmay.departmentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.madmay.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String departmentCode);
}
