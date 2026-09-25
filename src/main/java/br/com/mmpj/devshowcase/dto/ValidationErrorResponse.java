package br.com.mmpj.devshowcase.dto;

import java.util.Map;

public class ValidationErrorResponse {
    private String error;
    private Map<String, String> fieldErrors;

    public ValidationErrorResponse() {}

    public ValidationErrorResponse(String error, Map<String, String> fieldErrors) {
        this.error = error;
        this.fieldErrors = fieldErrors;
    }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public Map<String, String> getFieldErrors() { return fieldErrors; }
    public void setFieldErrors(Map<String, String> fieldErrors) { this.fieldErrors = fieldErrors; }
}
