package com.paypal.bfs.test.employeeserv.constants;

/**
 * Constants File
 */
public final class PaypalConstants {

    private PaypalConstants() {
    }

    public static final String MANDATORY_PARAMS_MISSING = "Mandatory parameters are missing from request.";
    public static final String EMPLOYEE_DOES_NOT_EXIST = "Employee with the given id does not exist.";
    public static final String EMPLOYEE_ENTITY_EXISTS = "Employee with same email already exists";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String WRONG_PARAMETERS = "Wrong parameters in request.";
}
