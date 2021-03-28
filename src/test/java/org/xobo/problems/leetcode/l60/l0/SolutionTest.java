package org.xobo.problems.leetcode.l60.l0;

import org.junit.jupiter.api.Test;
import org.xobo.problems.leetcode.base.ListNode;

class SolutionTest {

  @Test
  void test() {
    Solution solution = new Solution();
    ListNode listNode = solution.rotateRight(ListNode.createListNode(1, 2, 3, 4, 5), 2);
    System.out.println(listNode);
    listNode = solution.rotateRight(ListNode.createListNode(0, 1, 2), 4);
    System.out.println(listNode);
    listNode = solution.rotateRight(ListNode.createListNode(1), 9);
    System.out.println(listNode);
  }

}
