package com.kaya.marketapi.event;

import com.kaya.marketapi.model.Product;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ProductUpdatedEvent extends ApplicationEvent {

  private final Product product;

  public ProductUpdatedEvent(Object source, Product product) {
    super(source);
    this.product = product;
  }
}
