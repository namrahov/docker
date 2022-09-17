package com.roadrunner.accountservice.api;


import com.roadrunner.accountservice.service.AccountService;
import com.roadrunner.accountservice.service.impl.AccountServiceImpl;
import com.roadrunner.client.contract.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountApi {

    @Autowired
    private AccountService accountService;


    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id){
      return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id,
                                          @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.update(id, accountDto));
    }

    @DeleteMapping
    public void delete(String id) {
        accountService.delete(id);
    }



}
