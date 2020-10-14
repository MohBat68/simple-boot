package com.formation.service;

import org.springframework.stereotype.Service;

/**
 * Calculator.
 */

@Service
public class Calculator {
     public int sum(int a, int b) {
          return a + b;
     }
}