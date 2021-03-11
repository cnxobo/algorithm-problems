package org.xobo.problems.leetcode.l220.l227_basic_calculator2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BasicCalculatorTest {


  @Test
  void test() {
    String[] testCase = new String[] {"3+2*2", " 3/2 ", " 3+5 / 2 ", " 3+5 / -2 ", "5+6*-1*-2"};
    int[] results = new int[] {7, 1, 5, 1, 17};
    BasicCalculator2 basicCalculator = new BasicCalculator2Solution();

    for (int i = 0; i < results.length; i++) {
      int result = basicCalculator.calculate(testCase[i]);
      assertEquals(result, results[i], testCase[i]);
    }

  }



}
