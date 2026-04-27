package com.claro.sp.automation.model.subscriber;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pack {
    private String idPackSTH;
    private String idPackTN3;
    private Integer slotId;
    private String accountTypeId;
}
