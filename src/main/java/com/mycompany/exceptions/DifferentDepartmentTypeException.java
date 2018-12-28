package com.mycompany.exceptions;

public class DifferentDepartmentTypeException extends RuntimeException {
    public DifferentDepartmentTypeException(String message) {
        super(message);
    }
}
