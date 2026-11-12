
package com.site.aspect_oriented_programming.controller;

import com.site.aspect_oriented_programming.dto.Payment;
import com.site.aspect_oriented_programming.dto.PaymentRequest;
import com.site.aspect_oriented_programming.service.PaymentsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(
            @RequestBody PaymentRequest paymentRequest) {

        Payment payment = paymentsService.createPayment(paymentRequest);

        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Long> updatePayment(
            @RequestBody Long paymentId) {

        paymentsService.updatePayment(paymentId);

        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }
}
