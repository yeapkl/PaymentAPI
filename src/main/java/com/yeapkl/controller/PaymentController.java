package com.yeapkl.controller;

import com.yeapkl.entity.PaymentDetails;
import com.yeapkl.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(path="/getByCustomerId")
    public List<PaymentDetails> getByCustomerId(@RequestParam(value = "customerId") Long customerId,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return paymentService.getByCustomerId(customerId, pageable);
    }

    @GetMapping(path="/getByAccountNumber")
    public List<PaymentDetails> getByAccountNumber(@RequestParam(value = "accountNumber") Long accountNumber,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return paymentService.getByAccountNumber(accountNumber, pageable);
    }

    @GetMapping(path="/getByDescription")
    public List<PaymentDetails> getByDescription(@RequestParam(value = "description") String description,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return paymentService.getByDescription(description, pageable);
    }
}
