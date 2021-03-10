package org.xobo.problems.leetcode.l130.l131_palindrome_partitioning;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioningSolution1 implements PalindromePartitioning {

  public boolean isPalindrome(String s) {
    if (s.isEmpty()) {
      return false;
    }

    if (s.length() == 1) {
      return true;
    }

    if (s.length() % 2 != 0) {
      return false;
    }

    int endIndex = s.length() / 2;

    for (int i = 0; i < endIndex; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }

  public List<List<String>> partition(String s, List<String> unfinishedPalindrome) {
    if (s.length() == 0) {
      return Collections.emptyList();
    }



    for (int len = 1; len < s.length(); len++) {

      int splitIndex = s.length() - len;

      String lastStr = s.substring(splitIndex);
      if (isPalindrome(lastStr)) {
        List<List<String>> preList = partition(s.substring(0, splitIndex));
        for (List<String> list : preList) {
          list.add(lastStr);
        }
      }

    }


    Deque<Character> deque = new LinkedList<Character>();
    int[] dp = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {


    }
    return null;

  }

  public List<List<String>> partition(String s) {
    if (s.length() == 0) {
      return Collections.emptyList();
    }

    List<List<String>> preList = partition(s.substring(0, s.length() - 1));



    Character lastChar = s.charAt(s.length() - 1);

    for (List<String> list : preList) {
      list.add(lastChar.toString());
    }



    Deque<Character> deque = new LinkedList<Character>();
    int[] dp = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {


    }
    return null;
  }

}
