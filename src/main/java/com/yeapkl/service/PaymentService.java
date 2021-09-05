package com.yeapkl.service;

import com.yeapkl.entity.PaymentDetails;
import com.yeapkl.handler.PaymentDetailsNotFoundException;
import com.yeapkl.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentDetailsRepository paymentDetailsRepository;

    public List<PaymentDetails> getByCustomerId(Long customerId, Pageable pageable){
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAllByCustomerId(customerId, pageable);
        if(paymentDetails.isEmpty()){
            throw new PaymentDetailsNotFoundException("Customer ID Not Found : "+customerId);
        }
        return paymentDetails;
    }

    public List<PaymentDetails> getByAccountNumber(Long accountNumber, Pageable pageable){
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAllByAccountNumber(accountNumber, pageable);
        if(paymentDetails.isEmpty()){
            throw new PaymentDetailsNotFoundException("Account Number Not Found : "+accountNumber);
        }
        return paymentDetails;
    }

    public List<PaymentDetails> getByDescription(String description, Pageable pageable){
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAllByDescription(description, pageable);
        if(paymentDetails.isEmpty()){
            throw new PaymentDetailsNotFoundException("Description Not Found : "+description);
        }
        return paymentDetails;
    }
}
