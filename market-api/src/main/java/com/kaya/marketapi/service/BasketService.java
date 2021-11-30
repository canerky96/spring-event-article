package com.kaya.marketapi.service;

import com.kaya.marketapi.dto.BasketCreateRequestDTO;
import com.kaya.marketapi.model.Basket;
import com.kaya.marketapi.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasketService {

  private final ProductService productService;
  private final BasketRepository basketRepository;

  public Basket save(BasketCreateRequestDTO request) {
    var basket = new Basket();
    var products = productService.findAllByIdIn(request.getProductIds());
    basket.setProducts(products);
    return basketRepository.save(basket);
  }

  public List<Basket> getAll() {
    return basketRepository.findAll();
  }
}
