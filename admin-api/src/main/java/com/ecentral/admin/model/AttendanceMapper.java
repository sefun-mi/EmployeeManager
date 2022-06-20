package com.ecentral.admin.model;

import com.ecentral.entities.JpaAttendance;


public class AttendanceMapper {
    public static JpaAttendance attendanceToJpaAttendance(Attendance attendance){
        JpaAttendance jpaAttendance = new JpaAttendance();
        jpaAttendance.setDate(attendance.getDate());
        jpaAttendance.setEmployee(attendance.getEmployee());
        jpaAttendance.setId(attendance.getId());
        return jpaAttendance;
    }


    public static Attendance jpaAttendanceToAttendance(JpaAttendance jpaAttendance){
        Attendance attendance = new Attendance();
        attendance.setDate(jpaAttendance.getDate());
        attendance.setEmployee(jpaAttendance.getEmployee());
        attendance.setId(jpaAttendance.getId());
        return attendance;
    }
}
