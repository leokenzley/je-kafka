package com.leokenzley.ekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EkafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkafkaApplication.class, args);
	}

}
