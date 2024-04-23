package com.desafioitau.api.transferencia;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerLogConfig {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerLogConfig.class);

    @Bean
    public RegistryEventConsumer<CircuitBreaker> circuitBreakerRegistryEventConsumer() {
        return new RegistryEventConsumer<>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                entryAddedEvent
                        .getAddedEntry()
                        .getEventPublisher()
                        .onStateTransition(event -> logger.info(event.toString()));
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemovedEvent) {

            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {

            }
        };
    }

}