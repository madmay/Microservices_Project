package net.madmay.departmentservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.madmay.departmentservice.dto.DepartmentDto;
import net.madmay.departmentservice.entity.Department;
import net.madmay.departmentservice.exceptions.ResourceNotFoundException;
import net.madmay.departmentservice.repository.DepartmentRepository;
import net.madmay.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // create department dto to department jpa entity
        Department department = modelMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto saveDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department", "department code", departmentCode));

        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }

}
