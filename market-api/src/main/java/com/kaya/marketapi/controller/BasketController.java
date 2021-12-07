package com.kaya.marketapi.controller;

import com.kaya.marketapi.dto.BasketAddProductRequestDTO;
import com.kaya.marketapi.dto.BasketCreateRequestDTO;
import com.kaya.marketapi.model.Basket;
import com.kaya.marketapi.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<Basket> save(@RequestBody BasketCreateRequestDTO requestBody) {
    return new ResponseEntity<>(basketService.save(requestBody), HttpStatus.CREATED);
  }

  @PostMapping("{id}")
  public ResponseEntity<Basket> save(
      @PathVariable("id") Long id, @RequestBody @Validated BasketAddProductRequestDTO requestBody) {
    return ResponseEntity.ok(basketService.addProduct(id, requestBody.getProductId()));
  }

  @PostMapping("{id}/confirm")
  public ResponseEntity<Basket> confirm(@PathVariable("id") Long id) {
    return ResponseEntity.ok(basketService.confirm(id));
  }

  @GetMapping
  public ResponseEntity<List<Basket>> get() {
    return ResponseEntity.ok(basketService.getAll());
  }
}
