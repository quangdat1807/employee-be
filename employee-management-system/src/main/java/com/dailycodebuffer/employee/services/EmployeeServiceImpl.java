package com.dailycodebuffer.employee.services;

import com.dailycodebuffer.employee.entity.EmployeeEntity;
import com.dailycodebuffer.employee.model.Employee;
import com.dailycodebuffer.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        // BeanUtils.copyProperties(employee, employeeEntity);
        employeeEntity.setFullName(employee.getFullName());
        employeeEntity.setPhoneNumber(employee.getPhoneNumber());
        employeeEntity.setGender(employee.getGender());
        employeeEntity.setCreatedDate(employee.getCreatedDate());
        employeeEntity.setEmailId(employee.getEmailId());
        
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();

        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFullName(),
                        emp.getPhoneNumber(),
                        emp.getGender(),
                        emp.getCreatedDate(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        
        employeeEntity.setFullName(employee.getFullName());
        employeeEntity.setPhoneNumber(employee.getPhoneNumber());
        employeeEntity.setGender(employee.getGender());
        employeeEntity.setCreatedDate(employee.getCreatedDate());
        employeeEntity.setEmailId(employee.getEmailId());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
