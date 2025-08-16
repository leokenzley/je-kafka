package com.leokenzley.ekafka.resources.impl;

import com.leokenzley.ekafka.model.Payment;
import com.leokenzley.ekafka.resources.PaymentResource;
import com.leokenzley.ekafka.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PaymentResourceImpl implements PaymentResource {
  private final PaymentService paymentService;
  @Override
  public ResponseEntity<Payment> processPayment(Payment payment) {
    paymentService.sendPayment(payment);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
