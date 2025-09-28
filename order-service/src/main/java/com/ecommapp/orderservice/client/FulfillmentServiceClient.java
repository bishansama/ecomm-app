package com.ecommapp.orderservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class FulfillmentServiceClient implements IFulfillmentServiceClient {

    private final WebClient webClient;
    private final String fulfillmentServiceUrl = "http://fulfillment-service:8085";

    @Autowired
    public FulfillmentServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(fulfillmentServiceUrl).build();
    }

    public Mono<Map<String, Object>> validateOrder(Map<String, Object> orderData) {
        return webClient.post()
                .uri("/api/fulfillment/validate")
                .bodyValue(orderData)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Map<String, Object>) response);
    }

    public Mono<Map<String, Object>> initiateDelivery(String orderId, Map<String, Object> deliveryData) {
        return webClient.post()
                .uri("/api/fulfillment/delivery/{orderId}", orderId)
                .bodyValue(deliveryData)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Map<String, Object>) response);
    }
}