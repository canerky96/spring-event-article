package com.kaya.marketapi.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Collection;

@Getter
public class BasketConfirmEvent extends ApplicationEvent {

  private final Long id;
  private final Collection<Long> productIds;

  public BasketConfirmEvent(Object source, Long id, Collection<Long> productIds) {
    super(source);
    this.id = id;
    this.productIds = productIds;
  }
}
