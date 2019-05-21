package com.mars.model;


public class ErrorMessage {

    private String coderr;
    private String error;

    public ErrorMessage(String error) { 
        this.coderr = error;
    }

    public ErrorMessage(String error, String message) {
        this.coderr = error;
        this.error = message;
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCode() {
        return coderr;
    }

    public void setCode(String code) {
        this.coderr = code;
    }

    @Override
    public String toString() {
        return coderr + " - " + error;
    }
}
