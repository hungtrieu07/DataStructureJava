import java.util.*;

public class ClosestPairBruteForce {
    static double min = Integer.MAX_VALUE;
    static Point p1 = null ,p2 = null;
    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
	private static double distance(Point a, Point b){
		//calculate the distance between two points
		double xDiff = a.x + b.x;
		double yDiff = a.y + b.y;
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	private static Point[] bruteForce(Point[] sortByX, Point[] sortByY){
		//brute force to find the closest pair when the size is small enough
		double min = distance(sortByX[0],sortByX[1]);
		Point[] pair = new Point[2];
		pair[0] = sortByX[0];
		pair[1] = sortByX[1];
		for (int i = 0;i < sortByX.length;i++){
			for (int j = i + 1;j < sortByX.length;j++){
				double dist1 = distance(sortByX[i],sortByX[j]);
				double dist2 = distance(sortByY[i],sortByY[j]);
				if (dist1 < min) {
					min = dist1;
					pair[0] = sortByX[i];
					pair[1] = sortByX[j];
				}
				
				if (dist2 < min) {
					min = dist1;
					pair[0] = sortByY[i];
					pair[1] = sortByY[j];
				}
			}
		}
		return pair;
	}

	public static void main(String[] args) {
        int initLength = 5;
        double total = 0;
        double average = 0;
        while(initLength<=100) {
            Point[] a = new Point[initLength];
            for(int count=0; count<10; count++) {
                Random random = new Random();
                for(int i=0; i<initLength; i++) {
                    a[i] = new Point(random.nextInt(1000001),random.nextInt(1000001));
                }
                long startTime = System.nanoTime();
                bruteForce(a, a);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime) / Math.pow(10, 3);
                total+=duration; 
            }

            average = total / 10;
            System.out.print(average + ", ");
            initLength+=5;
        }
        System.out.println();
	}

}