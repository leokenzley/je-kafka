package com.leokenzley.ekafka.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumeListener {

  @KafkaListener(groupId = "group-1", topics = "${kafka-topic.name}", containerFactory = "containerFactory")
  public void consume(String message) {
    log.info("Message received: {}", message);
  }
}
