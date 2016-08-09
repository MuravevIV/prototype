package com.ilyamur.prototype.basic.spring.ui.dto;

import com.ilyamur.prototype.basic.spring.dto.AccountDto;

public class AccountTransferFormDto implements Cloneable {

    private AccountDto accountFrom;
    private AccountDto accountTo;
    private long amountKop;
    private String successMessage;
    private String failureMessage;

    public AccountTransferFormDto copy() {
        AccountTransferFormDto dto = new AccountTransferFormDto();
        dto.accountFrom = accountFrom.copy();
        dto.accountTo = accountTo.copy();
        dto.amountKop = amountKop;
        dto.successMessage = successMessage;
        dto.failureMessage = failureMessage;
        return dto;
    }
}
