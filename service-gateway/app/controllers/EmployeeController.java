package controllers;

import com.ecentral.admin.api.IAdmin;
import com.ecentral.admin.model.Admin;
import com.ecentral.employee.api.IEmployee;
import com.ecentral.employee.model.Attendance;
import com.ecentral.employee.model.Employee;
import com.encentral.scaffold.commons.util.MyObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Date;

@Transactional
@Api(value = "Employee")
public class EmployeeController extends Controller {

    @Inject
    IEmployee iEmployee;

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;

    @ApiOperation(value = "Change Password")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Employee.class, message = "password Changed")}
    )
    @ApiImplicitParams({
    })
    public Result changePassword(String employeeId, String password) {
        try {
            return iEmployee.changePassword(employeeId,password)
                    .map(employee -> ok(objectMapper.toJsonString(employee)))
                    .orElse(notFound());

        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }


    }

    @ApiOperation(value = "Change Password")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Employee.class, message = "password Changed")}
    )
    @ApiImplicitParams({
    })
    public Result markAttendance(String employeeId) {
        Date date = new Date();
        try {
            var key = iEmployee.markAttendance(employeeId,date).first();
            var value =iEmployee.markAttendance(employeeId,date).second();
            if(iEmployee.markAttendance(employeeId,date).first() ==null)
            {
                return notAcceptable(value);
            }
            return iEmployee.markAttendance(employeeId,date).first()
                    .map(employee -> ok(objectMapper.toJsonString(employee)))
                    .orElse(notFound());

        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }


    }
}
