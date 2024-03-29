package org.xobo.problems.leetcode.l50.l4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public static enum Direction {
    right, down, left, up;
  }

  private static final Direction[] DIRECTION_VALUES = Direction.values();

  public static class SpiralOrderMatirx {
    int maxWidth;
    int maxHeight;
    int currWidth;
    int currHeight;

    int topEdge = 0;
    int leftEdge = 0;
    int rightEdge = maxWidth - 1;
    int downEdge = maxHeight - 1;

    int total;
    int currSize;
    Direction currDirection;

    public SpiralOrderMatirx(int maxWidth, int maxHeight) {
      this.maxWidth = maxWidth;
      this.maxHeight = maxHeight;
      rightEdge = maxWidth - 1;
      downEdge = maxHeight - 1;
      total = maxWidth * maxHeight;
      currDirection = currWidth < rightEdge ? Direction.right : Direction.down;

      if (currDirection == Direction.right) {
        leftEdge = -1;
      }
    }



    boolean horizontal = true;



    Direction nextDirection() {
      if (currDirection == Direction.right) {
        leftEdge++;
      } else if (currDirection == Direction.down) {
        topEdge++;
      } else if (currDirection == Direction.left) {
        rightEdge--;
      } else if (currDirection == Direction.up) {
        downEdge--;
      }
      return DIRECTION_VALUES[(currDirection.ordinal() + 1) % 4];
    }

    public boolean next() {
      if (currDirection == Direction.right) {
        if (currWidth < rightEdge) {
          currWidth++;
        }
        if (currWidth == rightEdge) {
          currDirection = nextDirection();
        }
      } else if (currDirection == Direction.down) {
        if (currHeight < downEdge) {
          currHeight++;
        }
        if (currHeight == downEdge) {
          currDirection = nextDirection();
        }

      } else if (currDirection == Direction.left) {
        if (currWidth > leftEdge) {
          currWidth--;
        }
        if (currWidth == leftEdge) {
          currDirection = nextDirection();
        }
      } else if (currDirection == Direction.up) {
        if (currHeight > topEdge) {
          currHeight--;
        }
        if (currHeight == topEdge) {
          currDirection = nextDirection();
        }

      }

      return ++currSize < total;

    }

  }

  public List<Integer> spiralOrder(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    SpiralOrderMatirx spiralOrderMatirx = new SpiralOrderMatirx(width, height);

    List<Integer> list = new ArrayList<Integer>();
    list.add(matrix[0][0]);
    while (spiralOrderMatirx.next()) {
      list.add(matrix[spiralOrderMatirx.currHeight][spiralOrderMatirx.currWidth]);
    }

    return list;
  }


  public static void main(String[] args) {

    Solution solution = new Solution();
    int[][] nums = new int[][] {{3}, {2}};
    List<Integer> list = solution.spiralOrder(nums);
    System.out.println(list);

    int width = 10;
    int height = 10;
    SpiralOrderMatirx spiralOrderMatirx = new SpiralOrderMatirx(width, height);

    int[][] arrs = new int[height][width];

    System.out
        .println("[" + spiralOrderMatirx.currWidth + ", " + spiralOrderMatirx.currHeight + "]");
    int i = 1;
    while (spiralOrderMatirx.next()) {

      System.out
          .println("[" + spiralOrderMatirx.currWidth + ", " + spiralOrderMatirx.currHeight + "]");
      arrs[spiralOrderMatirx.currHeight][spiralOrderMatirx.currWidth] += i;
      i++;
    }

    for (int x = 0; x < height; x++) {
      System.out.println(Arrays.toString(arrs[x]));
    }
  }

}
