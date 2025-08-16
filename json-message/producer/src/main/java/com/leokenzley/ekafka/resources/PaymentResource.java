package com.leokenzley.ekafka.resources;

import com.leokenzley.ekafka.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/payments")
public interface PaymentResource {
  @PostMapping
  ResponseEntity<Payment> processPayment(@RequestBody Payment payment);
}
