package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatType extends BaseModel {
    private String seatTypeName;
}
