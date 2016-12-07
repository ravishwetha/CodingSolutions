//Reads 3 co-ords and creates Point objects. It then computes the centroid.

import java.util.*;
import java.awt.*;

public class TriangleCentroid {

	public static Point2D.Double centroid(Point v1, Point v2, Point v3) {
		double x = (v1.x+v2.x+v3.x)/3.0;
		double y = (v1.y+v2.y+v3.y)/3.0;
		Point2D c = new Point2D.Double(x, y);
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 3 vertices: ");
		
		int v1x = sc.nextInt();
		int v1y = sc.nextInt();
		Point v1 = new Point(v1x, v1y);
		
		int v2x = sc.nextInt();
		int v2y = sc.nextInt();
		Point v2 = new Point(v2x, v2y);
		
		int v3x = sc.nextInt();
		int v3y = sc.nextInt();
		Point v3 = new Point(v3x, v3y);

		System.out.println("Centroid at " + centroid(v1, v2, v3));
	}
}
