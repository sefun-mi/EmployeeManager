package com.ecentral.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendance")
@NamedQueries({
        @NamedQuery(name = "JpaAttendance.findAll", query = "SELECT j FROM JpaAttendance j")})
public class JpaAttendance {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Basic(optional = false)
    @JoinColumn(name = "employee_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private JpaEmployee employee;

    @Basic(optional = false)
    @Column(name = "attendance")
    private Date date;

    public JpaAttendance() {
    }

    public JpaAttendance(JpaEmployee employee, Date date) {
        this.employee = employee;
        this.date = date;
    }

    @Override
    public String toString() {
        return "JpaAttendance{" +
                "id=" + id +
                ", employee=" + employee +
                ", date=" + date +
                '}';
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
}
