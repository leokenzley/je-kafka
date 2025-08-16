package com.leokenzley.ekafka.listeners;

import com.leokenzley.ekafka.customer.ConsumerListenerCustom;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumeListener {

  @ConsumerListenerCustom(groupId = "group-1")
  public void consume(String message) {
    log.info("Message received: {}", message);
  }
}
