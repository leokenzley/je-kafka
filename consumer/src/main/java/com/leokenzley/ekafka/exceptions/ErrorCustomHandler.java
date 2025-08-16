package com.leokenzley.ekafka.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
  @Override
  public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
    log.info("capturando o error message: {}", exception.getMessage());
    log.info("capturando o error payload: {}", message.getPayload());
    log.info("capturando o error headers: {}", message.getHeaders());
    return null;
  }
}
