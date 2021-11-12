package com.stackinsat.test.controller;

import com.stackinsat.test.dto.AccountDTO;
import com.stackinsat.test.model.Account;
import com.stackinsat.test.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;
    private final ModelMapper modelMapper;

    @GetMapping("/accounts")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Account> findAccounts() {
        return modelMapper.map((List<Account>) accountService.findAll(),
                               new TypeToken<List<AccountDTO>>() {
                               }.getType());
    }
}
