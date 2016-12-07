//Given the side of square, computes the area of the smallest circle that can enclose it

import java.util.*;

public class CircleArea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter side of square: ");
		double sqrSide = sc.nextDouble();
		sc.nextLine();

		System.out.printf("Area of circle = %.2f", computeCircleArea(sqrSide));
		System.out.println();
	}

	public static double computeCircleArea(double side) {
		return Math.PI*(Math.pow(computeCircleRadius(side), 2));
	}

	public static double computeCircleRadius(double side) {
		return Math.pow((Math.pow(side/2, 2))*2, 0.5);
	}
}
