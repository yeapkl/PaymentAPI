package com.yeapkl.controller;

import com.yeapkl.model.PaymentDetailsResponse;
import com.yeapkl.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(path="/getByCustomerId")
    public PaymentDetailsResponse getByCustomerId(@RequestParam(value = "customerId") int customerId,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return new PaymentDetailsResponse(paymentService.getByCustomerId(customerId, pageable));
    }

    @GetMapping(path="/getByAccountNumber")
    public PaymentDetailsResponse getByAccountNumber(@RequestParam(value = "accountNumber") String accountNumber,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return new PaymentDetailsResponse(paymentService.getByAccountNumber(accountNumber, pageable));
    }

    @GetMapping(path="/getByDescription")
    public PaymentDetailsResponse getByDescription(@RequestParam(value = "description") String description,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return new PaymentDetailsResponse(paymentService.getByDescription(description, pageable));
    }
}
