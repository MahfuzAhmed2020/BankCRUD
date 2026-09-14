package com.example.bankcrud;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin
public class BankAccountController {

    private final BankAccountRepository repository;

    public BankAccountController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return repository.save(account);
    }

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public BankAccount updateAccount(@PathVariable Long id,
                                     @RequestBody BankAccount account) {
        BankAccount existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setCustomerName(account.getCustomerName());
        existing.setAccountNumber(account.getAccountNumber());
        existing.setBalance(account.getBalance());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        repository.deleteById(id);
        return "Bank account deleted successfully";
    }
}
