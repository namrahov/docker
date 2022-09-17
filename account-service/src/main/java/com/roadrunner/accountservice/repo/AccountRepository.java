package com.roadrunner.accountservice.repo;

import com.roadrunner.accountservice.entity.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account,String> {

}
