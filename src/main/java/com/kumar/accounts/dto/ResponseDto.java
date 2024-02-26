package com.kumar.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author RakeshKumar created on 23/02/24
 */

@Data @AllArgsConstructor
public class ResponseDto {
    private String statusCode;
    private  String statusMsg;
}
