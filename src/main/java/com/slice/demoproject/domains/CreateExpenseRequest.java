package com.slice.demoproject.domains;

import com.slice.demoproject.enums.Currency;
import com.slice.demoproject.enums.ExpenseCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateExpenseRequest {
  @NotNull(message = "createdBy is required")
  private Long createdBy;

  @NotBlank(message = "description must not be blank")
  private String description;

  @NotBlank(message = "amount must not be blank")
  private String amount;

  @NotNull(message = "currency is required")
  private Currency currency;

  @NotNull(message = "expenseCategory is required")
  private ExpenseCategory expenseCategory;
}
