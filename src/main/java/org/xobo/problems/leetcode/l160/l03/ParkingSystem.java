package org.xobo.problems.leetcode.l160.l03;
public class ParkingSystem {
  
  int []max = new int[3];
  int []capacity= new int[3];
  
  int currBig;
  int currMedium;
  int currSmall;

    public ParkingSystem(int big, int medium, int small) {
      max[0]= big;
      max[1]= medium;
      max[2]= small;
    }
    
    public boolean addCar(int carType) {
      carType -=1;
      if (capacity[carType] < max[carType]) {
        capacity[carType]++;
        return true;
      }
      return false;
    }
    
    public static void main(String[] args) {
      ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
      System.out.println(parkingSystem.addCar(1));
      System.out.println(parkingSystem.addCar(2));
      System.out.println(parkingSystem.addCar(3));
      System.out.println(parkingSystem.addCar(1));
      
      
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */