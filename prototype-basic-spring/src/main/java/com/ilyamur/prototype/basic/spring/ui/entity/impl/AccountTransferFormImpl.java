package com.ilyamur.prototype.basic.spring.ui.entity.impl;

import com.ilyamur.prototype.basic.spring.ui.dto.AccountTransferFormDto;
import com.ilyamur.prototype.basic.spring.entity.Account;
import com.ilyamur.prototype.basic.spring.exception.InsufficientFundsException;
import com.ilyamur.prototype.basic.spring.provider.AccountProvider;
import com.ilyamur.prototype.basic.spring.ui.entity.AccountTransferForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTransferFormImpl implements AccountTransferForm {

    @Autowired
    private AccountProvider accountProvider;

    private AccountTransferFormDto dto;

    @Override
    public void setDto(AccountTransferFormDto dto) {
        this.dto = dto;
    }

    public void transferCommand(long idAccountFrom, long idAccountTo, long amountKop) {
        Account accountFrom = accountProvider.get(idAccountFrom);
        Account accountTo = accountProvider.get(idAccountTo);
        try {
            accountFrom.transferTo(accountTo, amountKop);
        } catch (InsufficientFundsException e) {
            //
        }
    }
}
