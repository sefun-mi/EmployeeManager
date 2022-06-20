package com.ecentral.employee.impl;

import akka.japi.Pair;
import com.ecentral.employee.api.IEmployee;
import com.ecentral.employee.model.Attendance;
import com.ecentral.employee.model.AttendanceMapper;
import com.ecentral.employee.model.Employee;
import com.ecentral.employee.model.EmployeeMapper;
import com.ecentral.entities.JpaAttendance;
import com.ecentral.entities.JpaEmployee;
import com.querydsl.core.group.QPair;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class DefaultEmployeeimpl implements IEmployee {

    private final JPAApi jpaApi;

    @Inject
    public DefaultEmployeeimpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public Pair<Optional<Attendance>,String> markAttendance(String employeeId, Date date) {
        date=new Date();
        LocalDateTime now = LocalDateTime.now();
        if(now.getDayOfWeek().equals("SATURDAY") || now.getDayOfWeek().equals("SUNDAY")){
            return new Pair<>(null,"it is not a workday");
        }
        else if(now.getHour()>17){
            return new Pair<>(null,"it is too late to mark attendance");
        }
        else if(now.getHour()<9){
            return new Pair<>(null,"it is too early to mark attendance");

        }
        final var employeeAttendance = jpaApi.withTransaction(em -> em.find(JpaAttendance.class, employeeId));
        employeeAttendance.setDate(date);
        jpaApi.em().persist(employeeAttendance);
        return new Pair<>(ofNullable(employeeAttendance).map(AttendanceMapper::jpaAttendanceToAttendance),"Thank you for marking attendance");
    }

    @Override
    public Optional<Employee> changePassword(String employeeId, String newPassword) {
        var employee = jpaApi.withTransaction(em -> em.find(JpaEmployee.class, employeeId));
        if(!jpaApi.em().contains(employee))
        {
            employee = jpaApi.em().merge(employee);
        }
        employee.setEmployeePassword(newPassword);
        jpaApi.em().persist(employee);

        return ofNullable(employee).map(EmployeeMapper::jpaEmployeeToEmployee);
    }
}
