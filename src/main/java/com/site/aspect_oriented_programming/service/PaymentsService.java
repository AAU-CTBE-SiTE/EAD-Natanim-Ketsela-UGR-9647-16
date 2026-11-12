package com.site.aspect_oriented_programming.service;

import com.site.aspect_oriented_programming.dto.Payment;
import com.site.aspect_oriented_programming.dto.PaymentRequest;
import org.springframework.stereotype.Service;
import com.site.aspect_oriented_programming.annotation.TrackExecutionTime;

import java.math.BigDecimal;

@Service
public class PaymentsService {
    @TrackExecutionTime
    public Payment createPayment (PaymentRequest paymentRequest)  {
        if (paymentRequest.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid payment amount");
        }
        sleep(2000);
        Payment payment = new Payment();
        payment.setId("12345");
        payment.setAmount(paymentRequest.getAmount());
        payment.setCurrency(paymentRequest.getCurrency());
        payment.setStatus("CREATED");
        return payment;
    }

    @TrackExecutionTime
    public Payment updatePayment(Long paymentId) {

        sleep(1000);

        Payment payment = new Payment();

        payment.setId(String.valueOf(paymentId));
        payment.setAmount(new BigDecimal("100.00"));
        payment.setCurrency("USD");
        payment.setStatus("UPDATED");

        return payment;
    }
    private void sleep(int milliseconds) {

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
