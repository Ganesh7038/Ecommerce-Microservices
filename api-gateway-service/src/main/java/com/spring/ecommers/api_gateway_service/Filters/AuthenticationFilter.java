package com.spring.ecommers.api_gateway_service.Filters;

import com.spring.ecommers.api_gateway_service.Service.JwtService;
import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final JwtService jwtService;

    public AuthenticationFilter(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }

    @Override

    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {

            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

                String authorizationHeader = exchange .getRequest().getHeaders().getFirst("Authorization");

                if(authorizationHeader == null )
                {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                String token = authorizationHeader.split("Bearer ")[1];
                Long userId = jwtService.getUserIdFromToken(token);

                ServerWebExchange mutatedExchange = exchange.mutate()
                        .request(exchange.getRequest()
                                .mutate()
                                .header("X-User-Id", userId.toString())
                                .build())
                        .build();

                return chain.filter(mutatedExchange);
            }
        };
    }

    @Data
    public static class Config
    {

        private boolean enabled;

    }
}
