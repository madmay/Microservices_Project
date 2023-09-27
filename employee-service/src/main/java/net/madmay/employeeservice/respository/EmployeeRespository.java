package net.madmay.employeeservice.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.madmay.employeeservice.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}
