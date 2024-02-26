package com.kumar.accounts.dto;

import lombok.Data;

/**
 * @author RakeshKumar created on 23/02/24
 */
@Data
public class CustomerDto {
    private  String name;
    private  String email;
    private String mobileNumber;
    private  AccountsDto accountsDto;
}
