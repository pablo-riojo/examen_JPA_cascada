package com.JPA.cascade.bill.application;

import com.JPA.cascade.bill.domain.Bill;
import com.JPA.cascade.bill.infrastructure.repository.BillRepository;
import com.JPA.cascade.client.domain.Client;
import com.JPA.cascade.header.domain.Header;
import com.JPA.cascade.line.domain.Line;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
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

        Header initHeader = Header.builder()
                        .client(bill.getClient())
                        .bill(bill)
                        .billAmount(billAmount)
                        .build();
        initBill.setHeader(initHeader);

        repository.save(initBill);
    }

    @Override
    public List<Bill> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Line> addLine(List<Line> line, int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        Bill bill = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill with ID " + id + " not found"));

        repository.delete(bill);
    }
}
