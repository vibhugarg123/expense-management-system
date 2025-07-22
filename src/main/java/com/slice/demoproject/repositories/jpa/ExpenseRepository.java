package com.slice.demoproject.repositories.jpa;

import com.slice.demoproject.entities.Expense;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  Page<Expense> findAll(Specification<Expense> spec, Pageable pageable);

  Page<Expense> findAllByIdIn(List<Long> expenseIds, Pageable pageable);
  // Add custom query methods if needed
}
