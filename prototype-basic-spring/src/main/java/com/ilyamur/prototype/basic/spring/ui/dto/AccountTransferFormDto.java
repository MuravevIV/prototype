package com.ilyamur.prototype.basic.spring.ui.dto;

import com.ilyamur.prototype.basic.spring.dto.AccountDto;

public class AccountTransferFormDto {

    private AccountDto accountFromDto;
    private AccountDto accountToDto;
    private long amountKop;
    private String successMessage;
    private String failureMessage;

    public AccountDto getAccountFromDto() {
        return accountFromDto;
    }

    public void setAccountFromDto(AccountDto accountFromDto) {
        this.accountFromDto = accountFromDto;
    }

    public AccountDto getAccountToDto() {
        return accountToDto;
    }

    public void setAccountToDto(AccountDto accountToDto) {
        this.accountToDto = accountToDto;
    }

    public long getAmountKop() {
        return amountKop;
    }

    public void setAmountKop(long amountKop) {
        this.amountKop = amountKop;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public AccountTransferFormDto copy() {
        AccountTransferFormDto dto = new AccountTransferFormDto();
        dto.accountFromDto = accountFromDto.copy();
        dto.accountToDto = accountToDto.copy();
        dto.amountKop = amountKop;
        dto.successMessage = successMessage;
        dto.failureMessage = failureMessage;
        return dto;
    }
}
