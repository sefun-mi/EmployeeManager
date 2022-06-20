package controllers;

import com.ecentral.admin.api.IAdmin;
import com.ecentral.admin.model.Admin;
import com.ecentral.admin.model.Attendance;
import com.ecentral.admin.model.Employee;
import com.encentral.scaffold.commons.util.MyObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

@Transactional
@Api(value = "Admin")
public class AdminController extends Controller {

    @Inject
    IAdmin iAdmin;

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;




    @ApiOperation(value = "Create New Admin")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Admin.class, message = "Newly created Admin")}
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "body",
                    value = "Admin details",
                    paramType = "body",
                    required = true,
                    dataType = "com.ecentral.admin.model.Admin"
            )
    })
    public Result addAdmin() throws JsonProcessingException {
        Form<Admin> adminForm = formFactory.form(Admin.class).bindFromRequest();
        if (adminForm.hasErrors()) {
            return badRequest(adminForm.errorsAsJson());
        }

        return ok(objectMapper.writeValueAsString(iAdmin.addAdmin(adminForm.get())));
    }


    @ApiOperation(value = "Get a Admin")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Admin.class, message = "found Admin")}
    )
    @ApiImplicitParams({
    })
    public Result getAdmin(String adminId) {
        try {
            return iAdmin.getAdmin(adminId)
                    .map(admin -> ok(objectMapper.toJsonString(admin)))
                    .orElse(notFound());

        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }


    }

    @ApiOperation(value = "Create New Employee")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Employee.class, message = "Newly created Employee")}
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "body",
                    value = "Employee details",
                    paramType = "body",
                    required = true,
                    dataType = "com.ecentral.admin.model.Employee"
            )
    })
    public Result addEmployee() throws JsonProcessingException {
        Form<Employee> employeeForm = formFactory.form(Employee.class).bindFromRequest();
        if (employeeForm.hasErrors()) {
            return badRequest(employeeForm.errorsAsJson());
        }

        return ok(objectMapper.writeValueAsString(iAdmin.addEmployee(employeeForm.get())));
    }

    @ApiOperation(value = "Get a Employee")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Employee.class, message = "found Employee")}
    )
    @ApiImplicitParams({
    })
    public Result getEmployee(String employeeId) {
        try {
            return iAdmin.getEmployee(employeeId)
                    .map(employee -> ok(objectMapper.toJsonString(employee)))
                    .orElse(notFound());

        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }


    }


    @ApiOperation(value = "Delete an Employee")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Employee.class, message = "Employee Deleted")}
    )
    @ApiImplicitParams({
    })
    public Result removeEmployee(String employeeId) {
        try {
            return iAdmin.removeEmployee(employeeId)
                    .map(employee -> ok(objectMapper.toJsonString(employee)))
                    .orElse(notFound());

        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }


    }

    @ApiOperation(value = "Get a Employee Daily Attendance")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Attendance.class, message = "found Daily Attendance")}
    )
    @ApiImplicitParams({
    })
    public Result getEmployeeAttendance(String employeeId) {
        try {
            return iAdmin.getEmployeeAttendance(employeeId)
                    .map(employee -> ok(objectMapper.toJsonString(employee)))
                    .orElse(notFound());

        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }


    }

}
