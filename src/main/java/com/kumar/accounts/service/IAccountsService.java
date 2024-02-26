package com.kumar.accounts.service;

import com.kumar.accounts.dto.CustomerDto;

/**
 * @author RakeshKumar created on 24/02/24
 */

public interface IAccountsService {

    /*
    @param custmerDto CustomerDto Object
    */
    void createAccount(CustomerDto customerDto);

    /*
    * @param mobileNumber - input mobilenumber
    * @return Accounts Details based on a given mobile number
    * */
    CustomerDto fetchAccount(String mobileNumber);

}
