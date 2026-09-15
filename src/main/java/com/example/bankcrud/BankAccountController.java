package com.example.bankcrud;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin
public class BankAccountController {

    private final BankAccountRepository repository;

    public BankAccountController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Create account", description = "Creates a new bank account")
    @ApiResponse(responseCode = "200", description = "Accounts created successfully")
    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return repository.save(account);
    }

    @Operation(summary = "Get all accounts", description = "Returns all bank accounts")
    @ApiResponse(responseCode = "200", description = "Accounts retrieved successfully")
    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

    @Operation(summary = "Get account by ID", description = "Returns a bank account by its ID")
    @ApiResponse(responseCode = "200", description = "Account retrieved successfully")
    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @Operation(summary = "Update account", description = "Updates an existing bank account")
    @ApiResponse(responseCode = "200", description = "Account updated successfully")
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

    @Operation(summary = "Delete account", description = "Deletes a bank account by its ID")
    @ApiResponse(responseCode = "200", description = "Account deleted successfully")
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        repository.deleteById(id);
        return "Bank account deleted successfully";
    }
}
