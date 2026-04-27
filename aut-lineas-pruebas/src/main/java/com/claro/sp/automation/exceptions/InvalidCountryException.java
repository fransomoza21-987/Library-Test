package com.claro.sp.automation.exceptions;

public class InvalidCountryException extends Exception {
    private static final String INVALID_COUNTRY_DEFAULT_MESSAGE = "El país especificado no es válido.";

    public InvalidCountryException() {
        super(INVALID_COUNTRY_DEFAULT_MESSAGE);
    }
}
