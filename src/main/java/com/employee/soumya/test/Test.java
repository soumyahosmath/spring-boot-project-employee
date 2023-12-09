package com.employee.soumya.test;

public class Test {

	public static boolean searchMatrix(int[][] matrix, int target){
		if (matrix == null || matrix.length == 0  || matrix[0].length ==0) {
		return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int row = 0;
		int col = cols-1;
		while(row < rows && col>=0) {
		if(matrix[row][col] == target){
			return true;
		}
		else if(matrix[row][col] < target) {
		row++;}
		else {
		col--;
		}
		}
		return false;
		}

		public static void main(String[] args){
			System.out.println("hi");
		int[][] matrix = {
		  {1,  3,  5,  7},
		  {10 ,11, 16, 20},
		  {23, 30, 34, 60}};
		  
		  int target = 5;
		  boolean result = searchMatrix(matrix, target);
		  System.out.println(result);
		}

		

		}
	

