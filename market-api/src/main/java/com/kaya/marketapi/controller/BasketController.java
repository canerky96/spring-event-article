package com.kaya.marketapi.controller;

import com.kaya.marketapi.dto.BasketCreateRequestDTO;
import com.kaya.marketapi.model.Basket;
import com.kaya.marketapi.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BasketController.ENDPOINT)
@RequiredArgsConstructor
public class BasketController {

  public static final String ENDPOINT = "basket";

  private final BasketService basketService;

  @PostMapping
  public ResponseEntity<Basket> save(@RequestBody BasketCreateRequestDTO basket) {
    return new ResponseEntity<>(basketService.save(basket), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Basket>> get() {
    return ResponseEntity.ok(basketService.getAll());
  }
}
