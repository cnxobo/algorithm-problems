package org.xobo.problems.leetcode.l220.l224_basic_calculator;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorSolution2 implements BasicCalculator {
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

    System.out.println("=================");
    System.out.println(nums);
    System.out.println(operatorQueue);
  }


  public int calculate(String s) {
    Deque<Integer> nums = new LinkedList<>();
    Deque<Character> operatorQueue = new LinkedList<>();

    StringBuilder numBuilder = new StringBuilder();

    boolean hasPushNum = false;

    int sign = 1;

    for (int i = 0; i < s.length(); i++) {
      Character currChar = s.charAt(i);
      if (Character.isWhitespace(currChar)) {
        continue;
      } else if (Character.isDigit(currChar)) {
        numBuilder.append(currChar);
      } else {
        if (numBuilder.length() > 0) {
          nums.push(Integer.parseInt(numBuilder.toString()) * sign);

          System.out.println("=================");
          System.out.println(nums);
          System.out.println(operatorQueue);

          numBuilder = new StringBuilder();
          hasPushNum = true;
          sign = 1;
        }

        if (currChar == '(') {
          hasPushNum = false;
          if (sign < 1) {
            operatorQueue.push('-');
            sign = 1;
          }
          operatorQueue.push(currChar);
        } else if (currChar == ')') {
          Character operator = operatorQueue.pop();
          while (operator != '(') {
            System.out.println("=================");
            System.out.println(nums);
            System.out.println(operatorQueue);

            Integer num2 = nums.pop();
            Integer num1 = nums.pop();
            Integer result = calc(num1, num2, operator);
            nums.push(result);
            operator = operatorQueue.pop();

            System.out.println("=================");
            System.out.println(nums);
            System.out.println(operatorQueue);
          }
        } else {
          if (hasPushNum) {
            while (!operatorQueue.isEmpty()) {
              Character preOperator = operatorQueue.peek();
              int prePre = getPredence(preOperator);
              int currPre = getPredence(currChar);
              if (currPre <= prePre) {
                calc(nums, operatorQueue);
              } else {
                break;
              }
            }
            hasPushNum = false;
            operatorQueue.push(currChar);

            System.out.println("=================");
            System.out.println(nums);
            System.out.println(operatorQueue);
          } else {
            if (currChar == '-') {
              sign = -1;
            }

          }
        }
      }
    }
    if (numBuilder.length() > 0) {
      nums.push(Integer.parseInt(numBuilder.toString()));

      System.out.println("=================");
      System.out.println(nums);
      System.out.println(operatorQueue);


      numBuilder = new StringBuilder();
    }

    while (!operatorQueue.isEmpty()) {
      calc(nums, operatorQueue);
    }
    return nums.pop();
  }

  int getPredence(char c) {
    if (c == '+' || c == '-') {
      return 1;
    } else if (c == '*') {
      return 2;
    }
    return 0;
  }

}
