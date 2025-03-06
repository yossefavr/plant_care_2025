package com.plant_care_2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.plant_care_2025.model.Account;
import com.plant_care_2025.service.AccountService;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String listAccounts(Model model) {
        List<Account> accounts = accountService.getAllAccounts();
        model.addAttribute("accounts", accounts);
        model.addAttribute("account", new Account());
        return "ido"; 
    }

    @PostMapping("/save")
    public String saveAccount(@ModelAttribute Account account) {
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }

    // טעינת חשבון לעריכה
    @GetMapping("/edit/{accountNumber}")
    public String editAccount(@PathVariable String accountNumber, Model model) {
        Account account = accountService.getAccountByNumber(accountNumber);
        if (account == null) {
            return "redirect:/accounts";
        }
        model.addAttribute("account", account);
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "ido";
    }

    @GetMapping("/delete/{accountNumber}")
    public String deleteAccount(@PathVariable String accountNumber) {
        accountService.deleteAccount(accountNumber);
        return "redirect:/accounts";
    }
}
