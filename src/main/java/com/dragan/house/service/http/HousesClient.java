package com.dragan.house.service.http;

import com.dragan.house.service.model.House;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HousesClient extends BaseClient {

    @Value("${services.house-service.url}")
    private String baseUrl;

    protected String getBaseUrl() {
        return baseUrl;
    }

    public ResponseEntity<List<House>> getHouses(Integer priceGte, Integer priceLte, String city) {
        Map<String, Object> params = new HashMap<>();

        params.put("price_gte", priceGte);
        params.put("price_lte", priceLte);
        params.put("city", city);

        return executeRequest(HttpMethod.GET, "/houses", new ParameterizedTypeReference<List<House>>() {
        }, null, params);
    }
}
