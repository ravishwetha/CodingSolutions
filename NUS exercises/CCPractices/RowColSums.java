//To compute the row and column sums of a 2D array

import java.util.*;

public class RowColSums {
	public static void main(String[] args) {
		//code to read values into 2D array called 'array2D'
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of rows and columns: ");
		int numRows = sc.nextInt();
		int numCols = sc.nextInt();
		sc.nextLine();

		int[][] array2D = new int[numRows][numCols];

		System.out.println("Enter values for 2D array:");

		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numCols; j++) {
				array2D[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}

		int[] rowSums = computeRowSums(array2D);
		System.out.print("Row sums: ");
		System.out.println(Arrays.toString(rowSums));
		
		int[] colSums = computeColSums(array2D);
		System.out.print("Column sums: ");
		System.out.println(Arrays.toString(colSums));
	}

	public static int[] computeRowSums(int[][] arr) {
		int[] sum = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum[i]+=arr[i][j];
			}
		}
		return sum;
	}
	
	public static int[] computeColSums(int[][] arr) {
		int[] sum = new int[arr[0].length];
		for(int i=0; i<arr[0].length; i++) {
			for(int j=0; j<arr.length; j++) {
				sum[i]+=arr[j][i];
			}
		}
		return sum;
	}

	public static void print2Darray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
