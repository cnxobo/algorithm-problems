package org.xobo.problems.leetcode.l330.l1;

public class VerifyPreorderSerializationOfABinaryTree {
  public boolean isValidSerialization(String preorder) {

    String[] strs = preorder.split(",");
    if (strs[0].equals("#")) {
      return strs.length == 1;
    }

    int slot = 2;
    int i = 1;
    for (; i < strs.length && slot > 0; i++) {
      if (strs[i].equals("#")) {
        slot -= 1;
      } else {
        slot += 1;
      }

    }
    return i == strs.length && slot == 0;
  }

  public static void main(String[] args) {
    boolean result =
        new VerifyPreorderSerializationOfABinaryTree().isValidSerialization("7,2,#,2,#,#,#,6,#");
    System.out.println(result);
    result = new VerifyPreorderSerializationOfABinaryTree()
        .isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    System.out.println(result);
    result = new VerifyPreorderSerializationOfABinaryTree().isValidSerialization("9,#,#,1");
    System.out.println(result);
    result = new VerifyPreorderSerializationOfABinaryTree().isValidSerialization("1,#");
    System.out.println(result);
  }
}
