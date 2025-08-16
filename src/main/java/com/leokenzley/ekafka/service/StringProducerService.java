package com.leokenzley.ekafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StringProducerService {
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value("${kafka-topic.name}")
  private String topic;

  public void sendMessage(String message) {
    kafkaTemplate.send(topic, message);
  }
}
