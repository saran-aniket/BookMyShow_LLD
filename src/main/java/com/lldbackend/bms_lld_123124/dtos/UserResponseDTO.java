package com.lldbackend.bms_lld_123124.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String username;
    private String firstName;
    private String lastName;
    private DTOResponseStatus status;
    private String message;

    @Override
    public String toString() {
        return super.toString();
    }
}
