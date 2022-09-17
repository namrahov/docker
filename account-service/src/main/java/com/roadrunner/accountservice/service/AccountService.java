package com.roadrunner.accountservice.service;

import com.roadrunner.client.contract.AccountDto;


public interface AccountService {
    AccountDto get(String id);

    AccountDto save(AccountDto accountDto);

    AccountDto update(String id, AccountDto accountDto);

    void delete(String id);
}
