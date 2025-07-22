package com.slice.demoproject.repositories.specifications;

import com.slice.demoproject.domains.FetchExpenseRequest;
import com.slice.demoproject.entities.Expense;
import org.springframework.data.jpa.domain.Specification;

public class ExpenseSpecification {
  public static Specification<Expense> getExpenseSpecification(FetchExpenseRequest request) {

    return (root, query, cb) -> {
      var predicates = cb.conjunction();
      if (request.getUserId() != null) {
        predicates =
            cb.and(predicates, cb.equal(root.get("createdBy").get("id"), request.getUserId()));
      }
      if (request.getExpenseStatus() != null) {
        predicates =
            cb.and(predicates, cb.equal(root.get("status"), request.getExpenseStatus().name()));
      }
      if (request.getExpenseCategory() != null) {
        predicates =
            cb.and(predicates, cb.equal(root.get("category"), request.getExpenseCategory().name()));
      }
      if (request.getFromDate() != null) {
        predicates =
            cb.and(
                predicates, cb.greaterThanOrEqualTo(root.get("createdAt"), request.getFromDate()));
      }
      if (request.getToDate() != null) {
        predicates =
            cb.and(predicates, cb.lessThanOrEqualTo(root.get("createdAt"), request.getToDate()));
      }
      return predicates;
    };
  }
}
