package com.slice.demoproject.entities;

import com.slice.demoproject.enums.Currency;
import com.slice.demoproject.enums.ExpenseCategory;
import com.slice.demoproject.enums.ExpenseStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Expenses")
@Getter
@Setter
@ToString(callSuper = true)
@Accessors(chain = true)
public class Expense extends BaseEntity {
  private Double amount;

  @Enumerated(EnumType.STRING)
  private Currency currency;

  @Enumerated(EnumType.STRING)
  private ExpenseCategory category;

  @Enumerated(EnumType.STRING)
  private ExpenseStatus status;

  private String description;

  @ManyToOne
  @JoinColumn(name = "createdById")
  private User createdBy;

  @ManyToOne
  @JoinColumn(name = "approvedById")
  private User approvedBy;

  private String reviewComments;
  // TODO We can add expense attachments etc later in phase-2
}
