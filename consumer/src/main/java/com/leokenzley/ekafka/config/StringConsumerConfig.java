package com.leokenzley.ekafka.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

import java.util.HashMap;
import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@Configuration
public class StringConsumerConfig {
  private final KafkaProperties kafkaProperties;

  @Bean
  public ConsumerFactory<String, String> stringConsumerFactory() {
    var configs = new HashMap<String, Object>();
    configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class);
    configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class);
    return new DefaultKafkaConsumerFactory<>(configs);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory containerFactory(ConsumerFactory<String, String> consumerFactory) {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
    factory.setConsumerFactory(consumerFactory);
    factory.getContainerProperties().setPollTimeout(3000);
    return factory;
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory validaContainerFactory(ConsumerFactory<String, String> consumerFactory) {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
    factory.setConsumerFactory(consumerFactory);
    factory.getContainerProperties().setPollTimeout(3000);
    factory.setRecordInterceptor(validMessage());
    return factory;
  }


  private RecordInterceptor<String, String> validMessage() {
    return (record, consumer) -> {
      if(Objects.nonNull(record.value()) && record.value().contains("Teste")){
       log.info("Valid message received: {}", record.value());
        return record;
      }
      return record;
    };
  }
}
