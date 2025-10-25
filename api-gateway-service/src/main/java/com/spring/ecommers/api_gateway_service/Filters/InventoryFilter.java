package com.spring.ecommers.api_gateway_service.Filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class InventoryFilter extends AbstractGatewayFilterFactory<InventoryFilter.Config> {

    public InventoryFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

                log.info("Inventory Pre Filter start with Url {}", exchange.getRequest().getURI());
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {

                    log.info("Inventory Post Filter end with Url {}", exchange.getRequest().getURI());

                }));
            }
        };
    }

    public static class Config{

    }
}
