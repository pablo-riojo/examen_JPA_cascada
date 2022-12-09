package com.JPA.cascade.bill.infrastructure.controller;

import com.JPA.cascade.bill.application.BillSvc;
import com.JPA.cascade.bill.domain.Bill;
import com.JPA.cascade.bill.infrastructure.dto.BillMapper;
import com.JPA.cascade.bill.infrastructure.dto.BillOutputDTO;
import com.JPA.cascade.line.domain.Line;
import com.JPA.cascade.line.infrastructure.dto.LineInputDTO;
import com.JPA.cascade.line.infrastructure.dto.LineMapper;
import com.JPA.cascade.line.infrastructure.dto.LineOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    BillSvc svc;

    @GetMapping
    public List<BillOutputDTO> getAll() {
        List<Bill> list = svc.findAll();
        List<Line> lines = new ArrayList<>();
        list.forEach(b -> lines.addAll(b.getLine()));

        List<BillOutputDTO> response = list.stream().map(BillMapper.Instance::billToBillOutputDTO).toList();

        response.forEach(billDTO -> {
                    billDTO.getHeader().setClientId(billDTO.getClient().getId());
                    billDTO.setLines(lines.stream().map(LineMapper.Instance::lineToLineOutputDTO).toList());
                    billDTO.setBillAmount(list.get(list.size() - 1).getAmount());
                }
        );

        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws FileNotFoundException {
            svc.delete(id);
    }

    @PostMapping("{id}/line")
    @ResponseStatus(HttpStatus.CREATED)
    public List<LineOutputDTO> addLines(@PathVariable int id, @RequestBody List<LineInputDTO> newLines) {
        List<Line> newLinesList = newLines.stream().map(LineMapper.Instance::lineInputDTOtoLine).toList();

        List<Line> response = svc.addLine(newLinesList, id);

        return response.stream().map(LineMapper.Instance::lineToLineOutputDTO).toList();
    }
}
