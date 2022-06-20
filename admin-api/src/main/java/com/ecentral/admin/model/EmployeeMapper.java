package com.ecentral.admin.model;

import com.ecentral.admin.model.Employee;
import com.ecentral.entities.JpaEmployee;
import com.ecentral.entities.JpaEmployee;

public class EmployeeMapper {

    public static JpaEmployee employeeToJpaEmployee(Employee employee){
        JpaEmployee jpaEmployee = new JpaEmployee();
        jpaEmployee.setEmployeeId(employee.getEmployeeId());
        jpaEmployee.setEmployeeName(employee.getEmployeeName());
        jpaEmployee.setEmployeePassword(employee.getEmployeePassword());
        jpaEmployee.setEmployeeEmail(employee.getEmployeeEmail());
        jpaEmployee.setDateJoined(employee.getDateJoined());
        return jpaEmployee;
    }


    public static Employee jpaEmployeeToEmployee(JpaEmployee jpaEmployee){
        Employee employee = new Employee();
        employee.setEmployeeId(jpaEmployee.getEmployeeId());
        employee.setEmployeeEmail(jpaEmployee.getEmployeeEmail());
        employee.setEmployeeName(jpaEmployee.getEmployeeName());
        employee.setEmployeePassword(jpaEmployee.getEmployeePassword());
        employee.setDateJoined(jpaEmployee.getDateJoined());
        return employee;
    }
}
