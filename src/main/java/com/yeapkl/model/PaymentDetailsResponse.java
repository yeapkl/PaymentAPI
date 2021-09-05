package com.yeapkl.model;

import com.yeapkl.entity.PaymentDetails;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaymentDetailsResponse {

    private List<PaymentDetails> paymentDetails;
}
