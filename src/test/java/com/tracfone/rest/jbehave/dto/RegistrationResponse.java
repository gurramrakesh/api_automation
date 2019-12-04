package com.tracfone.rest.jbehave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {
    private  String faultId;
    private  String fault;
    private  String SuccessCode;
    private  String Message;

}
