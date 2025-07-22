package com.slice.demoproject.services;

import com.slice.demoproject.domains.BulkExpenseStatusUpdateRequest;
import com.slice.demoproject.domains.CreateExpenseRequest;
import com.slice.demoproject.domains.CreateExpenseResponse;
import com.slice.demoproject.domains.FetchExpenseRequest;
import com.slice.demoproject.entities.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpenseService {
  /**
   * Creates a new expense.
   *
   * @param request the request containing expense details
   * @return the created expense response
   */
  CreateExpenseResponse createExpense(CreateExpenseRequest request);

  /**
   * Updates an existing expense.
   *
   * @param id the ID of the expense to update
   * @param request the request containing updated expense details
   * @return the updated expense response
   */
  //  UpdateExpenseResponse updateExpense(Long id, UpdateExpenseRequest request);

  /**
   * Deletes an expense by its ID.
   *
   * @param id the ID of the expense to delete
   */
  //  void deleteExpense(Long id);

  Page<Expense> fetchExpenses(FetchExpenseRequest request, Pageable pageable);

  Page<Expense> bulkUpdateStatus(BulkExpenseStatusUpdateRequest request, Pageable pageable);
}
