package com.ilyamur.prototype.basic.spring.provider;

import com.ilyamur.prototype.basic.spring.dto.AccountDto;
import com.ilyamur.prototype.basic.spring.entity.Account;

public interface AccountProvider {

    Account create(AccountDto dto);

    Account get(long idAccountFrom);
}
