package irina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   //ввод n
        int m = in.nextInt();   //ввод m

        int k = 100;
        int s = 0;
        int i;
        int c = 0;

        int[] cirArray = new int[k];
        for (i = 0; i < k; i++) {
            cirArray[i] = s + 1;
            s += 1;
            if (s == n) {
                s = 0;
            }
        }

        System.out.print(cirArray[0]);

        for (i = 1; i < k; i++) {
            c = c + 1;
            if ( c + 1 == m && cirArray[i] != 1) {
                System.out.print(cirArray[i]);
                c = 0;
            }
        }
    }
}
