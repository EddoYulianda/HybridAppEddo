package com.eddo.hybridappeddo.model;

import java.util.List;

public class DataModel {
    private int code;
    String message;
    private List<UserModel> listusermodel;

    public DataModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
