package com.mozido.reports.exception;

import java.io.Serializable;

public class ErrorData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
    private String foreignErrorCode;
    private String description;
    private String message;
    private String severity;
    private boolean isSpecial;
    private boolean nonTranslated;


    public ErrorData(String description, boolean nonTranslated) {
        this.description = description;
        this.nonTranslated = nonTranslated;
    }

    public ErrorData(String code, String foreignErrorCode, String description, String message, boolean special,
                     boolean nonTranslated) {
        this.code = code;
        this.foreignErrorCode = foreignErrorCode;
        this.description = description;
        this.message = message;
        isSpecial = special;
        this.nonTranslated = nonTranslated;
    }

    public ErrorData() {
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public String getCode() {
        return code;
    }

    public String getForeignErrorCode() {
        return foreignErrorCode;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setForeignErrorCode(String foreignErrorCode) {
        this.foreignErrorCode = foreignErrorCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public boolean isNonTranslated() {
        return nonTranslated;
    }

    public void setNonTranslated(boolean nonTranslated) {
        this.nonTranslated = nonTranslated;
    }
}