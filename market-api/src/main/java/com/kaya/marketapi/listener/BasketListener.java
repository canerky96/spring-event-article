package com.kaya.marketapi.listener;

import com.kaya.marketapi.event.BasketConfirmEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BasketListener {

  @EventListener(BasketConfirmEvent.class)
  public void handle(BasketConfirmEvent event) {
    log.info("Basket confirmed with id: {}", event.getId());
  }
}
