package com.ecentral.admin.api;

import com.ecentral.admin.model.Admin;
import com.ecentral.admin.model.Attendance;
import com.ecentral.admin.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IAdmin {
    Admin addAdmin(Admin admin);

    Optional<Admin> getAdmin(String adminId);

    Employee addEmployee(Employee employee);

    Optional<Employee> getEmployee(String employeeId);

    Optional<Employee> removeEmployee(String employeeId);

    Optional<Attendance> getEmployeeAttendance(String employeeId);
}
