package com.ecentral.admin.model;

import com.ecentral.entities.JpaEmployee;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

public class Attendance {
    private JpaEmployee employee;
    private int id;
    private Date date;

    public Attendance() {
    }



    public JpaEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(JpaEmployee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "employee=" + employee +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
