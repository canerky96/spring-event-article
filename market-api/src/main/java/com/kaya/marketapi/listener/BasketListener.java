package com.kaya.marketapi.listener;

import com.kaya.marketapi.event.BasketConfirmEvent;
import com.kaya.marketapi.model.Product;
import com.kaya.marketapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class BasketListener {

  private final ProductService productService;

  // When you confirmed the basket, you must decrease the quantity of products in the basket
  @EventListener(BasketConfirmEvent.class)
  public void decreaseProductCount(BasketConfirmEvent event) {
    var products = productService.decreaseCounts(event.getProductIds());
    log.info(
        "Product counts decreased with names: {}, new quantities: {}",
        products.stream().map(Product::getName).collect(Collectors.toList()),
        products.stream().map(Product::getQuantity).collect(Collectors.toList()));
  }

  // Simulate E-mail
  @EventListener(BasketConfirmEvent.class)
  public void handle(BasketConfirmEvent event) {
    var productNames =
        productService.findAllByIdIn(event.getProductIds()).stream()
            .map(Product::getName)
            .collect(Collectors.toList());
    log.info("E-mail: Your basket confirmed with products: {}", productNames);
  }
}
