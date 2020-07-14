package com.company.DynamicsProgramming;

import java.util.Scanner;

public class NumberOfMethodCoin {
    public static int count(int[] d, int amount) {

        int[][] V = new int[amount + 1][d.length];

        /* Write down the base solution*/
        int i, j , x, y;
        for (j = 0; j < d.length; j++) {
            V[0][j] = 1;
        }

        /* Fill in the rest of the matrix using recursion relation */
        for (i = 1; i < amount+1; i++) {
            for (j = 0; j < d.length; j++) {
                x = (i-d[j] >= 0)? V[i - d[j]][j]: 0;
                y = (j >= 1)? V[i][j-1]: 0;
                V[i][j] = x + y;
            }
        }
        return V[amount][d.length-1];
    }

    public static void main(String[] args) {
        int[] d = {1,5,7,10};
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        System.out.println(count(d, amount));
        scan.close();
    }
}
