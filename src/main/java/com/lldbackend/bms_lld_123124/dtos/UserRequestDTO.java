package com.lldbackend.bms_lld_123124.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
