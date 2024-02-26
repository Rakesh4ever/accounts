package com.kumar.accounts.service.impl;

import com.kumar.accounts.constants.AccountsConstants;
import com.kumar.accounts.dto.AccountsDto;
import com.kumar.accounts.dto.CustomerDto;
import com.kumar.accounts.entity.Accounts;
import com.kumar.accounts.entity.Customer;
import com.kumar.accounts.exception.CustomerAlreadyExistsException;
import com.kumar.accounts.exception.ResourceNotFoundException;
import com.kumar.accounts.mapper.AccountMapper;
import com.kumar.accounts.mapper.CustomerMapper;
import com.kumar.accounts.respository.AccountsRepository;
import com.kumar.accounts.respository.CustomerRepository;
import com.kumar.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

/**
 * @author RakeshKumar created on 24/02/24
 */
@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    @Autowired
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /*
    @param custmerDto - CustomerDto Object
    */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer =customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber :"+customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer=customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }

    private Accounts createNewAccount(Customer customer){
        Accounts newAccounts=new Accounts();
        newAccounts.setCustomerId(customer.getCustomerId());
        long randomAccNumber=1000000000L +new Random().nextInt(900000000);
        newAccounts.setAccountNumber(randomAccNumber);
        newAccounts.setAccountType(AccountsConstants.SAVINGS);
        newAccounts.setBranchAddress(AccountsConstants.ADDRESS);
        newAccounts.setCreatedAt(LocalDateTime.now());
        newAccounts.setCreatedBy("Anonymous");
        return newAccounts;

    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
        Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()->new ResourceNotFoundException("Accounts","customerId",customer.getCustomerId().toString())
        );
        CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountsDto(AccountMapper.mapToAccountsDto(accounts,new AccountsDto()));
        return customerDto;
    }

}
