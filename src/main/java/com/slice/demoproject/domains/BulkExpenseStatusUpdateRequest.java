package com.slice.demoproject.domains;

import com.slice.demoproject.enums.ExpenseStatus;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BulkExpenseStatusUpdateRequest {
  private List<Long> expenseIds;
  private ExpenseStatus expenseStatus;
}
