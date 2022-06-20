package com.ecentral.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "JpaEmployee.findAll", query = "SELECT j FROM JpaEmployee j")})
public class JpaEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employee_id")
    private String employeeId;
    @Basic(optional = false)
    @Column(name = "employee_name")
    private String employeeName;

    @Basic(optional = false)
    @Column(name = "employee_email",unique = true)
    private String employeeEmail;

    @Basic(optional = false)
    @Column(name = "employee_password")
    private String employeePassword;

    @Column(name = "date_joined")
    private Date dateJoined;

    public JpaEmployee() {
    }

    public JpaEmployee(String employeeId) {
        this.employeeId = employeeId;
    }

    public JpaEmployee(String employeeId, String employeeName, String employeeEmail,String employeePassword) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail=employeeEmail;
        this.employeePassword=employeePassword;
    }

    public JpaEmployee(String employeeId,String employeeName, String employeeEmail,String employeePassword, Date dateJoined)
    {
        this.employeeId=employeeId;
        this.employeeName=employeeName;
        this.employeeEmail=employeeEmail;
        this.employeePassword=employeePassword;
        this.dateJoined=dateJoined;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
    //    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof JpaBook)) {
//            return false;
//        }
//        JpaBook other = (JpaBook) obj;
//        return (this.bookId != null || other.bookId == null) &&
//                (this.bookId == null || this.bookId.equals(other.bookId));
//    }
}
