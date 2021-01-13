package Exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[]ch1 = new int[n];
        int[]ch2 = new int[n];
        int [][]a = new int[n][2];
        for (int i = 0; i < n; i++) {
            ch1[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ch2[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i][0] = ch1[i];
            a[i][1] = ch2[i];
        }
        Arrays.sort(a, new Comparator<int []>() {
            @Override
            public int compare(int []o1, int []o2) {
                return o2[0] - o1[0];
            }
        });
        for(int[] i: a){
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
