package com.ecentral.admin.impl;

import com.ecentral.admin.api.IAdmin;
import com.ecentral.admin.model.*;
import com.ecentral.entities.JpaAdmin;
import com.ecentral.entities.JpaAttendance;
import com.ecentral.entities.JpaEmployee;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.*;

import static java.util.Optional.ofNullable;

public class DefaultAdminImpl implements IAdmin {
    private final JPAApi jpaApi;

    @Inject
    public DefaultAdminImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }


    @Override
    public Admin addAdmin(Admin admin) {

        JpaAdmin jpaAdmin = AdminMapper.adminToJpaAdmin(admin);
        jpaAdmin.setAdminId(UUID.randomUUID().toString());
        jpaApi.em().persist(jpaAdmin);
        return AdminMapper.jpaAdminToAdmin(jpaAdmin);
    }



    @Override
    public Optional<Admin> getAdmin(String adminId) {
        final var admin = jpaApi.withTransaction(em -> em.find(JpaAdmin.class, adminId));
        return ofNullable(admin).map(AdminMapper::jpaAdminToAdmin);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        JpaEmployee jpaEmployee = EmployeeMapper.employeeToJpaEmployee(employee );
        jpaEmployee.setEmployeeId(UUID.randomUUID().toString());
        Random random = new Random();
        jpaEmployee.setEmployeePassword(String.format("%04d", random.nextInt(10000)));
        jpaApi.em().persist(jpaEmployee);
        return EmployeeMapper.jpaEmployeeToEmployee(jpaEmployee);
    }

    @Override
    public Optional<Employee> getEmployee(String employeeId) {
        final var employee = jpaApi.withTransaction(em -> em.find(JpaEmployee.class, employeeId));
        return ofNullable(employee).map(EmployeeMapper::jpaEmployeeToEmployee);
    }


    @Override
    public Optional<Employee> removeEmployee(String employeeId) {
        var employee = jpaApi.withTransaction(em -> em.find(JpaEmployee.class, employeeId));
        if(!jpaApi.em().contains(employee))
        {
            employee = jpaApi.em().merge(employee);
        }
        jpaApi.em().remove(employee);
        return ofNullable(employee).map(EmployeeMapper::jpaEmployeeToEmployee);
    }

    @Override
    public Optional<Attendance> getEmployeeAttendance(String employeeId) {
        final var employee = jpaApi.withTransaction(em -> em.find(JpaAttendance.class, employeeId));
        return ofNullable(employee).map(AttendanceMapper::jpaAttendanceToAttendance);
    }


}
