package com.slice.demoproject.services.impl;

import com.slice.demoproject.domains.BulkExpenseStatusUpdateRequest;
import com.slice.demoproject.domains.CreateExpenseRequest;
import com.slice.demoproject.domains.CreateExpenseResponse;
import com.slice.demoproject.domains.FetchExpenseRequest;
import com.slice.demoproject.entities.Expense;
import com.slice.demoproject.entities.User;
import com.slice.demoproject.enums.ExpenseStatus;
import com.slice.demoproject.exceptions.ResourceNotFoundException;
import com.slice.demoproject.mappers.ExpenseMapper;
import com.slice.demoproject.repositories.jpa.ExpenseRepository;
import com.slice.demoproject.repositories.jpa.UserRepository;
import com.slice.demoproject.repositories.specifications.ExpenseSpecification;
import com.slice.demoproject.services.ExpenseService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

  private UserRepository userRepository;
  private ExpenseMapper expenseMapper;
  private ExpenseRepository expenseRepository;

  @Autowired
  public ExpenseServiceImpl(
      UserRepository userRepository,
      ExpenseMapper expenseMapper,
      ExpenseRepository expenseRepository) {
    this.userRepository = userRepository;
    this.expenseMapper = expenseMapper;
    this.expenseRepository = expenseRepository;
  }

  @Override
  public CreateExpenseResponse createExpense(CreateExpenseRequest request) {
    Optional<User> userEntityOptional = userRepository.findById(request.getCreatedBy());
    if (userEntityOptional.isEmpty()) {
      throw new ResourceNotFoundException("User not found with ID: " + request.getCreatedBy());
    }

    Expense expense = expenseMapper.toExpense(request, userEntityOptional.get());
    Expense savedExpense = expenseRepository.save(expense);

    return new CreateExpenseResponse()
        .setStatus(ExpenseStatus.PENDING)
        .setExpenseId(savedExpense.getId())
        .setExpenseCreatedAt(savedExpense.getCreatedAt());
  }

  @Override
  public Page<Expense> fetchExpenses(FetchExpenseRequest request, Pageable pageable) {
    var spec = ExpenseSpecification.getExpenseSpecification(request);
    return expenseRepository.findAll(spec, pageable);
  }

  @Override
  public Page<Expense> bulkUpdateStatus(BulkExpenseStatusUpdateRequest request, Pageable pageable) {
    List<Expense> expenses = expenseRepository.findAllById(request.getExpenseIds());
    for (Expense expense : expenses) {
      expense.setStatus(request.getExpenseStatus());
    }
    expenseRepository.saveAll(expenses);
    return expenseRepository.findAllByIdIn(request.getExpenseIds(), pageable);
  }
}
