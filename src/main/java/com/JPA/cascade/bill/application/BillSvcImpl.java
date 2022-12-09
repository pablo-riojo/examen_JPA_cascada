package com.JPA.cascade.bill.application;

import com.JPA.cascade.bill.domain.Bill;
import com.JPA.cascade.bill.infrastructure.repository.BillRepository;
import com.JPA.cascade.client.domain.Client;
import com.JPA.cascade.line.domain.Line;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillSvcImpl implements BillSvc {
    @Autowired
    BillRepository repository;

    @PostConstruct
    public void init() {
        Client initClient = Client.builder()
                .name("Pablo")
                .build();

        List<Line> initLines = new ArrayList<>();
        Line line1 = Line.builder()
                        .productName("Macbook Air M1")
                        .productPrice(900.00)
                        .productAmount(1)
                        .build();
        Line line2 = Line.builder()
                        .productName("Muji pen")
                        .productPrice(2.00)
                        .productAmount(5)
                        .build();

        initLines.add(line1);
        initLines.add(line2);
        double billAmount = initLines.stream().mapToDouble(line -> line.getProductPrice() * line.getProductAmount()).sum();

        Bill initBill = Bill.builder()
                .client(initClient)
                .line(initLines)
                .amount(billAmount)
                .build();

        Bill bill = repository.save(initBill);
        initBill.getLine().forEach(line -> line.setBill(bill));

        repository.save(initBill);
    }

    @Override
    public List<Bill> findAll() {
        return repository.findAll();
    }

    @Override
    public Bill findById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Bill with ID " + id + " not found")
        );
    }

    @Override
    public Line addLine(Line line, int id) {
        return null;
    }

    @Override
    public Bill save(Bill bill) {
        return repository.save(bill);
    }

    @Override
    public void delete(int id) {
        Bill bill = repository.findById(id).orElseThrow(() -> new RuntimeException("Bill with ID " + id + " not found"));

        repository.delete(bill);
    }
}
