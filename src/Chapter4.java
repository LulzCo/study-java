import java.util.Scanner;

public class Chapter4 {
    public static void main(String[] args) {
//        aboutRandom();;;;;;;;;;;
        printPyramid();
    }

    public static void aboutRandom() {
        int i = (int)(Math.random() * 3);           // 0.0 < Math.random() < 1.0
        System.out.println(i);
    }

    public static void printPyramid() {
//        System.out.println("피라미드를 몇층까지 만들겠습니까??");

//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
        int num = 4;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
