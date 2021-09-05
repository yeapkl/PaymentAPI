package com.yeapkl.repository;

import com.yeapkl.entity.PaymentDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDetailsRepository extends PagingAndSortingRepository<PaymentDetails,Integer> {
    List<PaymentDetails> findAllByCustomerId(int customerId, Pageable pageable);
    List<PaymentDetails> findAllByAccountNumber(String accountNumber, Pageable pageable);
    List<PaymentDetails> findAllByDescription(String description, Pageable pageable);
}
