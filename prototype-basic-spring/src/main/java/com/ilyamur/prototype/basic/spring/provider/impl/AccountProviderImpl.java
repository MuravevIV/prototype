package com.ilyamur.prototype.basic.spring.provider.impl;

import com.ilyamur.prototype.basic.spring.dto.AccountDto;
import com.ilyamur.prototype.basic.spring.entity.Account;
import com.ilyamur.prototype.basic.spring.provider.AccountProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AccountProviderImpl implements AccountProvider {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Account create(AccountDto dto) {
        Account account = ctx.getBean(Account.class);
        account.setDto(dto);
        return account;
    }

    @Override
    public Account get(long idAccount) {
        AccountDto dto = new AccountDto();
        dto.setId(idAccount);
        Account account = create(dto);
        account.sync();
        return account;
    }
}
