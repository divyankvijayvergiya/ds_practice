package com.company.heaps;

import java.util.PriorityQueue;

public class ConnectRopes {
    int connectStick(int[] arr) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int sum = 0;

        while (heap.size() > 1) {
            int min1 = heap.poll();
            int min2 = heap.poll();
            sum += min1 + min2;
            heap.add(min1 + min2);
        }

        return sum;
    }
}
