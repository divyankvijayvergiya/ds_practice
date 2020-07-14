package com.company;

import java.util.*;

//class representing Structure of node in the linked list

class Main {
    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public Main() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

    public static void main(String args[]) {

        Main obj = new Main();
        Scanner in = new Scanner(System.in);
        int array[] = new int[100];
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        //write your code here
        for (int i = 0; i < n; i++) {
            obj.addNum(array[i]);
            System.out.println(obj.findMedian());
        }


    }
}
