package net.madmay.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.madmay.employeeservice.dto.EmployeeDto;
import net.madmay.employeeservice.entity.Employee;

@Mapper
public interface EmployeeMapper {

    // Implementation for this interface
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee mapToEmployee(EmployeeDto employeeDto);

    EmployeeDto mapToEmployeeDto(Employee employee);
}
