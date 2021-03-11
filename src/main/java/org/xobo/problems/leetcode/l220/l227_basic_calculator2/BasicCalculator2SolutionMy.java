package org.xobo.problems.leetcode.l220.l227_basic_calculator2;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator2SolutionMy implements BasicCalculator2 {



  @Override
  public int calculate(String s) {
    Deque<Integer> nums = new LinkedList<>();
    Deque<Character> operatorQueue = new LinkedList<>();
    StringBuilder numBuilder = new StringBuilder();

    boolean hasPushNum = false;
    int sign = 1;

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      if (currChar == ' ') {
        continue;
      } else if (Character.isDigit(currChar)) {
        numBuilder.append(currChar);
      } else {
        if (numBuilder.length() > 0) {
          int newInt = Integer.parseInt(numBuilder.toString());
          if (!hasPushNum) {
            newInt = sign > 0 ? newInt : -newInt;
            sign = 1;
          }
          nums.push(newInt);
          numBuilder.delete(0, numBuilder.length());
          hasPushNum = true;
        }

        if (!hasPushNum && currChar == '-') {
          sign = -1;
          continue;
        }

        while (!operatorQueue.isEmpty()) {
          Character preOperator = operatorQueue.peek();
          int prePre = getPrecedence(preOperator);
          int currPre = getPrecedence(currChar);
          if (currPre <= prePre) {
            calc(nums, operatorQueue);
          } else {
            break;
          }
        }
        hasPushNum = false;
        operatorQueue.push(currChar);
      }
    }

    if (numBuilder.length() > 0) {
      int newInt = Integer.parseInt(numBuilder.toString());
      if (!hasPushNum) {
        newInt = sign > 0 ? newInt : -newInt;
        sign = 1;
      }
      nums.push(newInt);
      numBuilder.delete(0, numBuilder.length());
    }

    while (!operatorQueue.isEmpty()) {
      calc(nums, operatorQueue);
    }
    return nums.pop();

  }

  int calc(Integer num1, Integer num2, char operator) {
    int result = 0;
    switch (operator) {
      case '+':
        result = num1 + num2;
        break;
      case '-':
        result = num1 - num2;
        break;
      case '*':
        result = num1 * num2;
        break;
      case '/':
        result = num1 / num2;
        break;
      default:
        break;
    }
    return result;
  }

  void calc(Deque<Integer> nums, Deque<Character> operatorQueue) {
    Integer num2 = nums.pop();
    Integer num1 = nums.isEmpty() ? 0 : nums.pop();
    char operator = operatorQueue.pop();
    Integer result = calc(num1, num2, operator);
    nums.push(result);
  }


  int getPrecedence(char c) {
    if (c == '+' || c == '-') {
      return 1;
    } else if (c == '*' || c == '/') {
      return 2;
    }
    return 0;
  }

}
