package com.mycompany.exceptions;

public class IncompatibleDepartmentsException extends RuntimeException {
    public IncompatibleDepartmentsException(String message) {
        super(message);
    }
}
