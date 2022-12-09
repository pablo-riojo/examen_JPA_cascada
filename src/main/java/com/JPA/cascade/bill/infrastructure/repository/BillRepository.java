package com.JPA.cascade.bill.infrastructure.repository;

import com.JPA.cascade.bill.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
