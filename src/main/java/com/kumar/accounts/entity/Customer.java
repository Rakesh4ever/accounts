package com.kumar.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author RakeshKumar created on 23/02/24
 */
@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator ="native")
    @GenericGenerator(name = "native")
    private  Long customerId;
    private  String name;
    private  String email;
    private String mobileNumber;

}
