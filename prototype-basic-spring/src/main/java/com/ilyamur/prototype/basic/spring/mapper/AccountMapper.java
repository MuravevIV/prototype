package com.ilyamur.prototype.basic.spring.mapper;

import com.ilyamur.prototype.basic.spring.dto.AccountDto;

public interface AccountMapper {

    AccountDto save(AccountDto dto);

    AccountDto findById(long id);
}
