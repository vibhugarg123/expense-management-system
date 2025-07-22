package com.slice.demoproject.mappers;

import com.slice.demoproject.domains.CreateExpenseRequest;
import com.slice.demoproject.entities.Expense;
import com.slice.demoproject.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "lastModifiedAt", ignore = true)
  @Mapping(target = "createdBy", source = "user")
  @Mapping(target = "category", source = "request.expenseCategory")
  @Mapping(
      target = "status",
      expression = "java(com.slice.demoproject.enums.ExpenseStatus.PENDING)")
  Expense toExpense(CreateExpenseRequest request, User user);
}
