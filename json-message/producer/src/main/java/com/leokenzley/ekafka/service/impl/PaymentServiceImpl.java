package com.leokenzley.ekafka.service.impl;

import com.leokenzley.ekafka.model.Payment;
import com.leokenzley.ekafka.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

  private final KafkaTemplate<String, Serializable> kafkaTemplate;
  @Value("${kafka-topic.name}")
  private String topicName;

  @SneakyThrows
  @Override
  public void sendPayment(Payment payment) {
    log.info("Payment received {}", payment);
    Thread.sleep(1000);
    kafkaTemplate.send(topicName, payment);
  }
}
