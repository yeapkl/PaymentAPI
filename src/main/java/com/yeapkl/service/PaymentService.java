package com.yeapkl.service;

import com.yeapkl.entity.PaymentDetails;
import com.yeapkl.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentDetailsRepository paymentDetailsRepository;

    public List<PaymentDetails> getByCustomerId(int customerId, Pageable pageable){
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAllByCustomerId(customerId, pageable);
        return paymentDetails;
    }

    public List<PaymentDetails> getByAccountNumber(String accountNumber, Pageable pageable){
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAllByAccountNumber(accountNumber, pageable);
        return paymentDetails;
    }

    public List<PaymentDetails> getByDescription(String description, Pageable pageable){
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAllByDescription(description, pageable);
        return paymentDetails;
    }
}
