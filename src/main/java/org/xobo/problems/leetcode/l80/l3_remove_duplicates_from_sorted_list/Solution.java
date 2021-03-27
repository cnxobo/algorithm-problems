package org.xobo.problems.leetcode.l80.l3_remove_duplicates_from_sorted_list;

import org.xobo.problems.leetcode.base.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {

    ListNode newHead = new ListNode();
    newHead.next = head;

    ListNode curr = head;;
    ListNode newCurr = head;;

    while ((curr = curr.next) != null) {
      if (curr.val != newCurr.val) {
        newCurr.next = curr;
        newCurr = newCurr.next;
      }
    }
    newCurr.next = null;
    return head;

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.deleteDuplicates(ListNode.createListNode(1, 1, 2, 3)));
    System.out.println(solution.deleteDuplicates(ListNode.createListNode(1, 1, 1, 1)));
    System.out.println(solution.deleteDuplicates(ListNode.createListNode(1, 1, 2, 3, 3)));
  }
}
