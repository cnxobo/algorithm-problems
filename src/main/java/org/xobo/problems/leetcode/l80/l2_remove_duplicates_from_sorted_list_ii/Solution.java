package org.xobo.problems.leetcode.l80.l2_remove_duplicates_from_sorted_list_ii;

import org.xobo.problems.leetcode.base.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode newHead = new ListNode();
    ListNode newCurr = newHead;
    ListNode curr = head;

    while (curr != null) {
      if (curr.next != null) {
        if (curr.val != curr.next.val) {
          newCurr.next = curr;
          newCurr = newCurr.next;
        } else {
          int sameValue = curr.val;
          while (curr != null && curr.val == sameValue) {
            curr = curr.next;
          }
          continue;
        }
      } else {
        newCurr.next = curr;
        newCurr = newCurr.next;
      }
      curr = curr.next;
    }
    newCurr.next = null;
    return newHead.next;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode listNode = null;

    listNode = solution.deleteDuplicates(ListNode.createListNode(1, 2, 3, 3, 4, 4, 5));
    System.out.println(listNode);
    listNode = solution.deleteDuplicates(ListNode.createListNode(1, 2, 2, 3, 3));
    System.out.println(listNode);
    listNode = solution.deleteDuplicates(ListNode.createListNode(1, 2, 3, 3, 4, 4, 5));
    System.out.println(listNode);
    listNode = solution.deleteDuplicates(ListNode.createListNode(1, 1, 1, 2, 3));
    System.out.println(listNode);
    listNode = solution.deleteDuplicates(ListNode.createListNode(1, 1, 1, 2, 2, 3, 3));
    System.out.println(listNode);
    listNode = solution.deleteDuplicates(ListNode.createListNode(1, 2, 2, 3, 3));
    System.out.println(listNode);
  }
}
