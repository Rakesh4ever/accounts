package com.kumar.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
/**
 * @author RakeshKumar created on 23/02/24
 */
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity{
    @Column(name="customer_id")
    private Long customerId;
    @Column(name = "account_number")
    @Id
    private  Long accountNumber;
    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

}
