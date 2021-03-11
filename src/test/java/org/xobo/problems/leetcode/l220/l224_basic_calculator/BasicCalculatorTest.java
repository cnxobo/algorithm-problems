package org.xobo.problems.leetcode.l220.l224_basic_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BasicCalculatorTest {


  @Test
  void test() {
    String[] testCase =
        new String[] {"(1+(4+5+2)-3)+(6+8)", "-1+1", "-1+(-1-1-1)", "- (3 + (4 + 5))", "5+6"};
    int[] results = new int[] {23, 0, -1, -12, 11};
    BasicCalculator basicCalculator = new BasicCalculatorSolution();

    for (int i = 0; i < results.length; i++) {
      int result = basicCalculator.calculate(testCase[i]);
      assertEquals(result, results[i], testCase[i]);
    }

  }



}
