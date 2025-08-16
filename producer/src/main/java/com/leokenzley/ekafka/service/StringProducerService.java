package com.leokenzley.ekafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.SendResult;
import java.util.concurrent.CompletableFuture;
@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value("${kafka-topic.name}")
  private String topic;

  public void sendMessage(String message) {
    CompletableFuture<SendResult<String, String>> future =
      kafkaTemplate.send(topic, message).toCompletableFuture();
    future.whenComplete((result, ex) -> {
      if (ex != null) {
        log.error("Failed to send message: {}", message, ex);
      } else {
        log.info("Message sent successfully: {}", message);
        log.info("Metadata: {}", result);
      }
    });
  }
}
