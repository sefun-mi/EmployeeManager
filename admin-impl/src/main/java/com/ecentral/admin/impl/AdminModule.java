package com.ecentral.admin.impl;

import com.ecentral.admin.api.IAdmin;
import com.google.inject.AbstractModule;

public class AdminModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IAdmin.class).to(DefaultAdminImpl.class);
    }
}
