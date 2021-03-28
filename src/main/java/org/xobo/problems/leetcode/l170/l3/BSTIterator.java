package org.xobo.problems.leetcode.l170.l3;

import java.util.Deque;
import java.util.LinkedList;

import org.xobo.problems.leetcode.base.TreeNode;

/**
 * @formatter:off
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * @formatter:on
 */
public class BSTIterator {

  Deque<TreeNode> treeNodeDeque = new LinkedList<TreeNode>();


  public BSTIterator(TreeNode root) {
    pushNewNode(root);
  }

  TreeNode pushNewNode(TreeNode curr) {
    if (curr == null) {
      return curr;
    }
    treeNodeDeque.push(curr);
    while (curr.left != null) {
      curr = curr.left;
      treeNodeDeque.push(curr);
    }
    return curr;
  }

  public int next() {
    TreeNode treeNode = treeNodeDeque.pop();
    Integer value = treeNode.val;
    pushNewNode(treeNode.right);
    return value;
  }

  public boolean hasNext() {
    return !treeNodeDeque.isEmpty();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(20);

    BSTIterator BSTIterator = new BSTIterator(root);
    while (BSTIterator.hasNext()) {
      System.out.println(BSTIterator.next());
    }

  }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new
 * BSTIterator(root); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
 */
