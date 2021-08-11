import java.util.Scanner;

public class demo {

    public static double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(y1 - x1, 2) + Math.pow(y2 - x2, 2));
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter how many numbers you want to check: ");
        int numbers = scan.nextInt();
        System.out.println("Fill in the points: ");
        double[][] list = new double[numbers][2];
        double n1=0,n2=0,n3=0,n4=0;
        list[0][0] = scan.nextDouble();
        list[0][1]= scan.nextDouble();
        list[1][0] = scan.nextDouble();
        list[1][1]= scan.nextDouble();
        double min = calculateDistance(list[0][0],list[0][1],list[1][0],list[1][1]);
        for (int i = 2;i<list.length;i++) {
        list[i][0] = scan.nextDouble();
        list[i][1] = scan.nextDouble();
        }

        for (int j=0;j<list.length;j++) {
            for(int k=j+1; k<list.length;k++) {
                if (calculateDistance(list[j][0],list[j][1],list[k][0],list[k][1]) < min) {
                    min = calculateDistance(list[j][0],list[j][1],list[k][0],list[k][1]);
                    n1 = list[j][0];
                    n2 = list[j][1];
                    n3 = list[k][0];
                    n4 = list[k][1];
                }
            }
        }

        System.out.println("The closest two points are " + "("+n1+" ," + n2+")" +"("+n3+" ," + n4+ ")") ;
    }
}