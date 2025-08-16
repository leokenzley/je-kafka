package com.leokenzley.ekafka.service;

import com.leokenzley.ekafka.model.Payment;

public interface PaymentService {
  void sendPayment(Payment payment);
}
