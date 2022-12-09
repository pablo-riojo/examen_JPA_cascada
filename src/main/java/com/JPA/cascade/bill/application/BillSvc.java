package com.JPA.cascade.bill.application;

import com.JPA.cascade.bill.domain.Bill;
import com.JPA.cascade.line.domain.Line;

import java.util.List;

public interface BillSvc {
    List<Bill> findAll();
    Bill findById(int id);
    Line addLine(Line line, int id);
    Bill save(Bill bill);
    void delete(int id);
}
