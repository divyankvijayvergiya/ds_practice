package com.company.DynamicsProgramming;

import java.util.Scanner;

public class SuperHeroJump {
    public static int min(int m, int n){
        return m>n ? n: m;
    }

    public static int minJump(int n)
    {
        int f[] = new int[n+1];

        /* Initialize the base condition*/
        f[1] = 0;


        /* Fill in the array to find Minimum Jumps from a certain distance*/
        int i,x;
        for (i = 2; i <= n; i++)
        {
            x = f[i-1];
            if(i%2==0){
                x = min(f[i/2], x);
            }
            if(i%3==0){
                x = min(x, f[i/3]);
            }
            f[i]=x + 1;
        }
        return f[n];
    }

    public static void main (String args[])
    {
        Scanner scan = new Scanner(System.in);
        int distance = scan.nextInt();
        if(distance>0){
            System.out.println(minJump(distance));
        }
        else {
            System.out.println("Distance should be a positive integer");
        }
    }
}
