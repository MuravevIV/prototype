package com.ilyamur.prototype.basic.spring.entity.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.ilyamur.prototype.basic.spring.dto.AccountDto;
import com.ilyamur.prototype.basic.spring.entity.Account;
import com.ilyamur.prototype.basic.spring.exception.InsufficientFundsException;
import com.ilyamur.prototype.basic.spring.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("prototype")
public class AccountImpl implements Account {

    @Autowired
    private AccountMapper mapper;

    private volatile AccountDto dto;

    @Override
    public void setDto(AccountDto dto) {
        this.dto = dto;
    }

    private AccountDto getDtoCopy() {
        return dto.copy();
    }

    @Override
    @Transactional(rollbackFor = {InsufficientFundsException.class})
    public void transferTo(Account other, long amountKop) throws InsufficientFundsException {
        checkNotNull(other, "Account to transfer to should not be null.");
        checkArgument(amountKop > 0, "Amount should be greater than zero.");

        AccountImpl otherImpl = (AccountImpl) other;

        this.setDto(mapper.save(this.getDtoCopy()));
        otherImpl.setDto(mapper.save(otherImpl.getDtoCopy()));

        AccountDto thisUpdDto = incAmountKop(this.getDtoCopy(), -amountKop);
        AccountDto otherUpdDto = incAmountKop(otherImpl.getDtoCopy(), amountKop);

        AccountDto thisNewDto = mapper.save(thisUpdDto);
        AccountDto otherNewDto = mapper.save(otherUpdDto);

        this.setDto(thisNewDto);
        otherImpl.setDto(otherNewDto);
    }

    @Override
    public void sync() {
        long id = dto.getId();
        AccountDto byId = mapper.findById(id);
        setDto(byId);
    }

    private AccountDto incAmountKop(AccountDto dto, long amountKop) throws InsufficientFundsException {
        long updAmountKop = dto.getAmountKop() + amountKop;
        if (updAmountKop >= 0) {
            dto.setAmountKop(updAmountKop);
            return dto;
        } else {
            throw new InsufficientFundsException();
        }
    }
}
