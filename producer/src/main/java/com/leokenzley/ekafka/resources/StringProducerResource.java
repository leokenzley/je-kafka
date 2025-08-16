package com.leokenzley.ekafka.resources;

import com.leokenzley.ekafka.service.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
@RequiredArgsConstructor
public class StringProducerResource {
  private final StringProducerService stringProducerService;

   @PostMapping
   public ResponseEntity<Void> sendMessage(@RequestBody String message) {
     stringProducerService.sendMessage(message);
     return ResponseEntity.status(HttpStatus.CREATED).build();
   }
}
