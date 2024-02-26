package com.kumar.accounts.mapper;

import com.kumar.accounts.dto.AccountsDto;
import com.kumar.accounts.entity.Accounts;

/**
 * @author RakeshKumar created on 24/02/24
 */

public class AccountMapper {  // THIS mapper class map the Entity class to DTO and from DTO to Entity

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
