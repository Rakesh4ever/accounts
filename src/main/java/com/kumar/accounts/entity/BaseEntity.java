package com.kumar.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author RakeshKumar created on 23/02/24
 */
@MappedSuperclass   //This annotation allow us to treat BaseEntity class as a Super class for all Entity classes
@Getter @Setter @ToString
public class BaseEntity {
    @Column(updatable = false) //createdAt field can not be updated once it get created if [updatable = false]
    private LocalDateTime createdAt;
    @Column(updatable = false)
    private String createdBy;
    @Column(insertable = false)
    private  LocalDateTime updatedAt;
    @Column(insertable = false)
    private  String updatedBy;
}
