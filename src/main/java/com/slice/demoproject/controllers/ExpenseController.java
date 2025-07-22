package com.slice.demoproject.controllers;

import com.slice.demoproject.domains.BulkExpenseStatusUpdateRequest;
import com.slice.demoproject.domains.CreateExpenseRequest;
import com.slice.demoproject.domains.CreateExpenseResponse;
import com.slice.demoproject.domains.FetchExpenseRequest;
import com.slice.demoproject.entities.Expense;
import com.slice.demoproject.services.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/expenses")
public class ExpenseController {

  private ExpenseService expenseService;

  @Autowired
  public ExpenseController(ExpenseService expenseService) {
    this.expenseService = expenseService;
  }

  @PostMapping
  public CreateExpenseResponse createExpense(@RequestBody @Valid CreateExpenseRequest request) {
    return expenseService.createExpense(request);
  }

  @GetMapping("/specification")
  public Page<Expense> getExpenses(
      FetchExpenseRequest request, @PageableDefault(size = 20) Pageable pageable) {
    return expenseService.fetchExpenses(request, pageable);
  }

  @PutMapping("/bulk-status-update")
  public Page<Expense> bulkUpdateStatus(
      @RequestBody @Valid BulkExpenseStatusUpdateRequest request,
      @PageableDefault(size = 20) Pageable pageable) {
    return expenseService.bulkUpdateStatus(request, pageable);
  }
}
