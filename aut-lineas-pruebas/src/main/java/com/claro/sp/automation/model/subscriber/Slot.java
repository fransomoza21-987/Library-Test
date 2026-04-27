package com.claro.sp.automation.model.subscriber;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Slot {
    private String pkgDefId;
    private Integer pkgQuantityLeft;
    private Date pkgExpiry;
    private String pkgRenewal;
   }
