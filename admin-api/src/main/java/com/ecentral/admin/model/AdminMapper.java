package com.ecentral.admin.model;

import com.ecentral.entities.JpaAdmin;

public class AdminMapper {

    public static JpaAdmin adminToJpaAdmin(Admin admin){
        JpaAdmin jpaAdmin = new JpaAdmin();
        jpaAdmin.setAdminId(admin.getAdminId());
        jpaAdmin.setAdminUsername(admin.getAdminUsername());
        jpaAdmin.setAdminPassword(admin.getAdminPassword());
        jpaAdmin.setAdminName(admin.getAdminName());
        return jpaAdmin;
    }


    public static Admin jpaAdminToAdmin(JpaAdmin jpaAdmin){
        Admin admin = new Admin();
        admin.setAdminId(jpaAdmin.getAdminId());
        admin.setAdminUsername(jpaAdmin.getAdminUsername());
        admin.setAdminName(jpaAdmin.getAdminName());
        admin.setAdminPassword(jpaAdmin.getAdminPassword());
        return admin;
    }
}
