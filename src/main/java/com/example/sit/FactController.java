package com.example.sit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class FactController {

  private final WebClient factWebclient;

  public FactController(WebClient factWebclient) {
    this.factWebclient = factWebclient;
  }

  @GetMapping("/facts")
  public String getAllFacts() {
    return this.factWebclient
      .get()
      .uri("/facts")
      .retrieve()
      .bodyToMono(String.class)
      .block();
  }
}
