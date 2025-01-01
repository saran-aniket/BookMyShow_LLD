package com.lldbackend.bms_lld_123124.exceptions;

public class UserExistsException extends Exception{
    @Override
    public String getMessage() {
        return "User already exists";
    }
}
