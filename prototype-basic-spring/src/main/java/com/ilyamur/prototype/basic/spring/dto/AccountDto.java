package com.ilyamur.prototype.basic.spring.dto;

public class AccountDto {

    private Long id;
    private long amountKop;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAmountKop() {
        return amountKop;
    }

    public void setAmountKop(long amountKop) {
        this.amountKop = amountKop;
    }

    public AccountDto copy() {
        AccountDto dto = new AccountDto();
        dto.id = id;
        dto.amountKop = amountKop;
        return dto;
    }
}
