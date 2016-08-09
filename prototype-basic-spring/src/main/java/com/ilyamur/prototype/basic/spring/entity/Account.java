package com.ilyamur.prototype.basic.spring.entity;

import com.ilyamur.prototype.basic.spring.exception.InsufficientFundsException;

public interface Account {

    void transferTo(Account other, long amountKop) throws InsufficientFundsException;

    void sync();

    void save() throws InsufficientFundsException;
}
