package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private String referenceNumber;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String paymentMode;
    private int amount;
}
