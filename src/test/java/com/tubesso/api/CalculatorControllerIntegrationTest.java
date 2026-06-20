package com.tubesso.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/health mengembalikan status UP")
    void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("UP")));
    }

    @Test
    @DisplayName("GET /api/add mengembalikan hasil penjumlahan yang benar")
    void testAddEndpoint() throws Exception {
        mockMvc.perform(get("/api/add").param("a", "10").param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(15)));
    }

    @Test
    @DisplayName("GET /api/divide mengembalikan hasil pembagian yang benar")
    void testDivideEndpoint() throws Exception {
        mockMvc.perform(get("/api/divide").param("a", "20").param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(5.0)));
    }

    @Test
    @DisplayName("GET /api/is-prime mengembalikan true untuk angka prima")
    void testIsPrimeEndpoint() throws Exception {
        mockMvc.perform(get("/api/is-prime").param("n", "13"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isPrime", is(true)));
    }
}
