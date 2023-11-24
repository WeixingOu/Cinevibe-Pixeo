package com.cinevibe.utils;

import com.cinevibe.dtos.CustomerDTO;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerUtils {
    private CustomerUtils() {}

    public static Map<String, Object> ResponseEntity(Long id, CustomerDTO customerDTO, String msg, HttpStatus httpStatus) {
        Map<String, Object> ApiResponse = new LinkedHashMap<>();
        ApiResponse.put("timestamp", new Date());
        ApiResponse.put("status", httpStatus.value());
        ApiResponse.put("error", httpStatus);
        ApiResponse.put("message", msg);
        ApiResponse.put("param", id);
        ApiResponse.put("path", "/api/customers/" + id);
        ApiResponse.put("customer", customerDTO);

        return ApiResponse;
    }
}
