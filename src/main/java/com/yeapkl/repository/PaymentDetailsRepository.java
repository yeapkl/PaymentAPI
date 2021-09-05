package com.yeapkl.repository;

import com.yeapkl.entity.PaymentDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDetailsRepository extends PagingAndSortingRepository<PaymentDetails,Long> {
    List<PaymentDetails> findAllByCustomerId(Long customerId, Pageable pageable);
    List<PaymentDetails> findAllByAccountNumber(Long accountNumber, Pageable pageable);
    List<PaymentDetails> findAllByDescription(String description, Pageable pageable);
}
