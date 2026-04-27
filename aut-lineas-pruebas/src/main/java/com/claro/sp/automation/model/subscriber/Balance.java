package com.claro.sp.automation.model.subscriber;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class Balance {
    private final Bags name;
    private Integer amount;
    private Date expiry;

    public Balance(Bags name, Integer amount, Date expiry) {
        this.name = name;
        this.amount = amount;
        this.expiry = expiry;
    }
}
