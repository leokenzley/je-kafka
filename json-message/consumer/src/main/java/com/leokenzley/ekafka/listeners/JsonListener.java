package com.leokenzley.ekafka.listeners;

import com.leokenzley.ekafka.customer.ConsumerListenerCustom;
import com.leokenzley.ekafka.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

  @SneakyThrows
  @ConsumerListenerCustom(groupId = "anti-fraud-group",errorHandler = "errorCustomHandler")
  public void antiFraud(@Payload Payment payment) {
    log.info("Validate payment: {}", payment);
    sleep(1000);
  }

  @SneakyThrows
  @ConsumerListenerCustom(groupId = "pdf-group",errorHandler = "errorCustomHandler")
  public void pdfGenerate(@Payload Payment payment) {
    log.info("Generating PDF ... {}", payment);
    sleep(1000);
  }

  @SneakyThrows
  @ConsumerListenerCustom(groupId = "email-group",errorHandler = "errorCustomHandler")
  public void sendEmail(@Payload Payment payment) {
    log.info("send confirmation e-mail: {}", payment);
    sleep(1000);
  }
}
