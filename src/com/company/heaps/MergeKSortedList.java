package com.company.heaps;

import java.util.*;

//class representing Structure of node in the linked list
class Node {
    int data;
    Node next;
};

class MergeKSortedList {

    /*merges the k sorted linked lists and returns
    the head of the resultant merged linked list*/
    Node mergeFunction(List<Node> arr, int k) {
        Node head = null, last = null;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });

        //Add the head nodes of all the k linked lists to the 'minHeap'
        for (int i = 0; i < k; i++)
            minHeap.add(arr.get(i));

        //loop till 'minHeap' is not empty
        while (minHeap.size() > 0) {

            // get the peek element of 'minHeap'
            Node peek = minHeap.peek();

            //remove the peek element of the min heap
            minHeap.poll();

            // check If the next element of the peek element, in the linked list from which it has been taken, is not null
            if (peek.next != null)

                //add the next node to 'minHeap'
                minHeap.add(peek.next);

            // if merged list is empty
            if (head == null) {
                head = peek;
                last = peek;
            }

            //if merged list is not empty
            else {
                // add 'peek' to the end of the merged list so far
                last.next = peek;

                // update the 'last' pointer
                last = peek;
            }
        }


        // head node of the required merged list
        return head;
    }

    // function to print the singly linked list
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    //creates a new node with the given 'data' and returns that node
    Node newNode (int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = null;

        return newNode;
    }

    // Driver program to test above
    public static void main(String args[]) {

        //array list whose each element is the head of each linked list
        ArrayList<Node> arr = new ArrayList<>();
        MergeKSortedList obj = new MergeKSortedList();

        Scanner in = new Scanner(System.in);

        // Number of linked lists
        int k = in.nextInt();

        // Number of elements in each linked list
        int n = in.nextInt();

        Node tmp = null;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {

                //head node of the linked list
                if (j == 0) {
                    int dt = in.nextInt();
                    arr.add(obj.newNode (dt));
                } else {
                    int dt = in.nextInt();
                    tmp = arr.get(i);
                    for (int m = 1; m < j; m++) {
                        tmp = tmp.next;
                    }
                    tmp.next = obj.newNode (dt);
                }
            }
        }

        Node head = obj.mergeFunction(arr, k);

        //print the merged resultant linked list
        obj.printList(head);
    }
}
