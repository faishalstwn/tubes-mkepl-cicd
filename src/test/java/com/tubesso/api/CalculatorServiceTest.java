package com.tubesso.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("Penjumlahan dua angka positif")
    void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    @DisplayName("Pengurangan menghasilkan angka negatif")
    void testSubtractNegativeResult() {
        assertEquals(-1, calculatorService.subtract(2, 3))
    }

    @Test
    @DisplayName("Perkalian dua angka")
    void testMultiply() {
        assertEquals(12, calculatorService.multiply(3, 4));
    }

    @Test
    @DisplayName("Pembagian dua angka menghasilkan double")
    void testDivide() {
        assertEquals(2.5, calculatorService.divide(5, 2));
    }

    @Test
    @DisplayName("Pembagian dengan nol melempar exception")
    void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(10, 0));
    }

    @Test
    @DisplayName("Angka prima terdeteksi dengan benar")
    void testIsPrimeTrue() {
        assertTrue(calculatorService.isPrime(7));
        assertTrue(calculatorService.isPrime(2));
    }

    @Test
    @DisplayName("Angka bukan prima terdeteksi dengan benar")
    void testIsPrimeFalse() {
        assertFalse(calculatorService.isPrime(8));
        assertFalse(calculatorService.isPrime(1));
        assertFalse(calculatorService.isPrime(0));
    }
}
