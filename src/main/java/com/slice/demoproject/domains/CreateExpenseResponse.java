package com.slice.demoproject.domains;

import com.slice.demoproject.enums.ExpenseStatus;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateExpenseResponse {
  private ExpenseStatus status;
  private Long expenseId;
  private LocalDateTime expenseCreatedAt;
}
