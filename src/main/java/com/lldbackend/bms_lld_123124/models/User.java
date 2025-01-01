package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
}
