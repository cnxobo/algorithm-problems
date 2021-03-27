package org.xobo.problems.leetcode.l90.l2;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }



  public static ListNode createListNode(int... values) {
    ListNode head = new ListNode();
    ListNode curr = head;
    for (int i : values) {
      curr.next = new ListNode(i);
      curr = curr.next;
    }
    return head.next;

  }

  @Override
  public String toString() {
    ListNode curr = this;
    List<Integer> list = new ArrayList<>();
    int i = 0;
    while (curr != null && i < 10) {
      list.add(curr.val);
      curr = curr.next;
      i++;
    }
    return list.toString();
  }
}


public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reverseBetween(ListNode.createListNode(1, 2, 3, 4, 5), 2, 4));
    System.out.println(solution.reverseBetween(ListNode.createListNode(5), 1, 1));
    System.out.println(solution.reverseBetween(ListNode.createListNode(1, 2, 3, 4, 5), 1, 5));
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) {
      return head;
    }
    int i = 0;

    ListNode head2 = new ListNode(-1, head);
    ListNode curr = head2;

    ListNode leftEdge = null;
    ListNode rightEdge = null;
    ListNode previousNode = null;
    ListNode nextNode = null;

    while (curr != null) {
      nextNode = curr.next;

      if (i + 1 == left) {
        leftEdge = curr;
        rightEdge = curr.next;
        leftEdge.next = null;
      } else if (i >= left && i <= right) {
        if (i == right) {
          leftEdge.next = curr;
        }

        if (i != left) {
          curr.next = previousNode;
        } else {
          curr.next = null;
        }

      } else if (i == right + 1) {
        rightEdge.next = curr;
      }

      previousNode = curr;
      curr = nextNode;
      i++;
    }

    return head2.next;
  }
}
