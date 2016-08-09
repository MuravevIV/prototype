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

    @Override
    public void transferCommand() {
        Account accountFrom = accountProvider.load(dto.getAccountFromDto().getId());
        Account accountTo = accountProvider.load(dto.getAccountToDto().getId());
        try {
            accountFrom.transferTo(accountTo, dto.getAmountKop());
            dto.setAmountKop(0);
            dto.setSuccessMessage("ok");
            dto.setFailureMessage("");
        } catch (InsufficientFundsException e) {
            dto.setSuccessMessage("");
            dto.setFailureMessage("Insufficient funds.");
        }
        dto.setAccountFromDto(accountFrom.getDtoCopy());
        dto.setAccountToDto(accountTo.getDtoCopy());
        save();
    }

    @Override
    public void save() {
        // UIForm update
    }
}
