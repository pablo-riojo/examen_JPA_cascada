package com.JPA.cascade.bill.application;

import com.JPA.cascade.bill.domain.Bill;
import com.JPA.cascade.line.domain.Line;

import java.io.FileNotFoundException;
import java.util.List;

public interface BillSvc {
    List<Bill> findAll();
    List<Line> addLine(List<Line> line, int id);
    void delete(int id) throws FileNotFoundException;
}
