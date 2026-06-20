package com.tubesso.api;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "tubes-cicd-api");
    }

    @GetMapping("/add")
    public Map<String, Object> add(@RequestParam int a, @RequestParam int b) {
        return Map.of("result", calculatorService.add(a, b));
    }

    @GetMapping("/subtract")
    public Map<String, Object> subtract(@RequestParam int a, @RequestParam int b) {
        return Map.of("result", calculatorService.subtract(a, b));
    }

    @GetMapping("/multiply")
    public Map<String, Object> multiply(@RequestParam int a, @RequestParam int b) {
        return Map.of("result", calculatorService.multiply(a, b));
    }

    @GetMapping("/divide")
    public Map<String, Object> divide(@RequestParam int a, @RequestParam int b) {
        return Map.of("result", calculatorService.divide(a, b));
    }

    @GetMapping("/is-prime")
    public Map<String, Object> isPrime(@RequestParam int n) {
        return Map.of("number", n, "isPrime", calculatorService.isPrime(n));
    }
}
