package com.kaya.marketapi.service;

import com.kaya.marketapi.dto.BasketCreateRequestDTO;
import com.kaya.marketapi.event.BasketConfirmEvent;
import com.kaya.marketapi.model.Basket;
import com.kaya.marketapi.model.Product;
import com.kaya.marketapi.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasketService {

  private final ProductService productService;
  private final BasketRepository basketRepository;
  private final ApplicationEventMulticaster applicationEventMulticaster;

  public Basket save(BasketCreateRequestDTO request) {
    var basket = new Basket();
    var products = productService.findAllByIdIn(request.getProductIds());
    basket.setProducts(products);
    return basketRepository.save(basket);
  }

  public List<Basket> getAll() {
    return basketRepository.findAll();
  }

  public Basket addProduct(Long id, Long productId) {
    var product = productService.findById(productId);
    var basket = this.findById(id);
    basket.getProducts().add(product);
    return basketRepository.save(basket);
  }

  public Basket confirm(Long id) {
    var basket = findById(id);
    var productIds = basket.getProducts().stream().map(Product::getId).collect(Collectors.toList());
    applicationEventMulticaster.multicastEvent(new BasketConfirmEvent(this, id, productIds));
    return basket;
  }

  private Basket findById(Long id) {
    return basketRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Basket not found with given id: " + id));
  }
}
