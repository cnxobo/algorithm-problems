package org.xobo.problems.leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *  int val; ListNode next; 
 *  ListNode() {}
 *   ListNode(int val) { this.val = val; } 
 *   ListNode(int val, ListNode next) { 
 *      this.val = val;
 *      this.next = next;
 *   } }
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
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


