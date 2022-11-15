package com.example.apigateway.filters;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.result.view.RequestContext;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
@Slf4j
public class LogFilter implements GlobalFilter, Ordered {

    final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
        logger.info("First Pre Global Filter : "+exchange.getRequest().getURI());

        ServerHttpRequest request = exchange.getRequest()
                .mutate()
                .header("PreFilter", "this is header pre filter")
                .build();

        HttpHeaders headers = exchange.getRequest().getHeaders();
        Set<String> headerNames = headers.keySet();

        headerNames.forEach((header) -> {
            logger.info(header + " " + headers.get(header));
        });

        //ServerWebExchange exchange1 = exchange.mutate().request(request).build();
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return -1;
    }
}

