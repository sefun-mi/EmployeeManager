package com.ecentral.employee.impl;

import com.ecentral.employee.api.IEmployee;
import com.google.inject.AbstractModule;

public class EmployeeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IEmployee.class).to(DefaultEmployeeimpl.class);
    }
}
