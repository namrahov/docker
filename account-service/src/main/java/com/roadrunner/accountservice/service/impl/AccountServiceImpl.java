package com.roadrunner.accountservice.service.impl;

import com.roadrunner.accountservice.dto.AccountDto;
import com.roadrunner.accountservice.entity.Account;
import com.roadrunner.accountservice.repo.AccountRepository;
import com.roadrunner.accountservice.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private  AccountRepository accountRepository;


    @Autowired
    private ModelMapper modelMapper;


    public AccountDto get(String id){
         Account account = accountRepository.findById(id).
                 orElseThrow(()->new IllegalArgumentException());
         return modelMapper.map(account, AccountDto.class);

    }

    @Transactional
    public AccountDto save(AccountDto accountDto){
        Account account = modelMapper.map(accountDto,Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> account = accountRepository.findById(id);
        Account accountToUpdate = account.map(it -> {
            it.setName(accountDto.getName());
            return it;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(accountRepository.save(accountToUpdate), AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        accountRepository.delete(account);
    }



}
