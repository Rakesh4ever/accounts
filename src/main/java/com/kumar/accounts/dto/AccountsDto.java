package com.kumar.accounts.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author RakeshKumar created on 23/02/24
 */

@Data
public class AccountsDto {
   //In DTO we shouldn't share CustomerId, we we not added customerId field here.
    private  Long accountNumber;
    private String accountType;

    private String branchAddress;
}
