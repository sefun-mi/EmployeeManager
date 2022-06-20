package com.ecentral.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "admin")
@NamedQueries({
        @NamedQuery(name = "JpaAdmin.findAll", query = "SELECT j FROM JpaAdmin j")})
public class JpaAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "admin_id")
    private String adminId;

    @Basic(optional = false)
    @Column(name = "admin_name")
    private String adminName;

    @Basic(optional = false)
    @Column(name = "admin_username")
    private String adminUsername;

    @Basic(optional = false)
    @Column(name = "admin_password")
    private String adminPassword;


    public JpaAdmin() {
    }

    public JpaAdmin(String adminId) {
        this.adminId = adminId;
    }

    public JpaAdmin(String adminId, String username, String adminPassword) {
        this.adminId = adminId;
        this.adminUsername = username;
        this.adminPassword=adminPassword;
    }


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
