package com.ecentral.employee.api;

import akka.japi.Pair;
import com.ecentral.employee.model.Attendance;
import com.ecentral.employee.model.Employee;

import java.util.Date;
import java.util.Optional;

public interface IEmployee {
    Pair<Optional<Attendance>,String> markAttendance(String employeeId, Date date);

    Optional<Employee> changePassword(String employeeId, String newPassword);
}
