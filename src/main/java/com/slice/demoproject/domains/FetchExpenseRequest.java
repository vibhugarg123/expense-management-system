package com.slice.demoproject.domains;

import com.slice.demoproject.enums.ExpenseCategory;
import com.slice.demoproject.enums.ExpenseStatus;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class FetchExpenseRequest {
  private Long userId;
  private ExpenseStatus expenseStatus;
  private ExpenseCategory expenseCategory;
  private LocalDateTime fromDate;
  private LocalDateTime toDate;
}
