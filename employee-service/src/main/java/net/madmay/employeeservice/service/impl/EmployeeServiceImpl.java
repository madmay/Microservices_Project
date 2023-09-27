package net.madmay.employeeservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.madmay.employeeservice.dto.EmployeeDto;
import net.madmay.employeeservice.entity.Employee;
import net.madmay.employeeservice.exceptions.ResourceNotFoundException;
import net.madmay.employeeservice.mapper.EmployeeMapper;
import net.madmay.employeeservice.respository.EmployeeRespository;
import net.madmay.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRespository employeeRespository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // converting employee dto to employee
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRespository.save(employee);

        // converting employee entity to employee dto
        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRespository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "empployee id", employeeId.toString()));

        // converting employee entity to employee dto
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        return employeeDto;
    }

}
