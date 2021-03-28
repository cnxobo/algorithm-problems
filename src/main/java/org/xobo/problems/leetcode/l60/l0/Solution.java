package org.xobo.problems.leetcode.l60.l0;

import org.xobo.problems.leetcode.base.ListNode;


class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }

    ListNode fastNode, slowNode;
    fastNode = slowNode = head;

    for (int i = 0; i < k; i++) {
      fastNode = fastNode.next;
      if (fastNode == null) {
        fastNode = head;
      }
    }

    while (fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next;
    }

    if (slowNode.next == null) {
      return head;
    }

    ListNode newHead = slowNode.next;
    slowNode.next = null;
    fastNode.next = head;

    return newHead;

  }

}
