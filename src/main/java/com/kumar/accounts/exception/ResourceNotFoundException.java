package com.kumar.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author RakeshKumar created on 26/02/24
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
   // public ResourceNotFoundException(String message){
   public ResourceNotFoundException(String resourceName, String fieldName,String fieldValue){
        //super(message);
       super(String.format("%s Not found with given input data %s: %s",resourceName,fieldName,fieldValue));
    }
}
