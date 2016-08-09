package com.ilyamur.prototype.basic.spring.entity;

import com.ilyamur.prototype.basic.spring.dto.AccountDto;
import com.ilyamur.prototype.basic.spring.exception.InsufficientFundsException;

public interface Account {

    void setDto(AccountDto dto);

    AccountDto getDtoCopy();

    void transferTo(Account other, long amountKop) throws InsufficientFundsException;

    void load();

    void save();
}
