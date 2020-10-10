package com.misc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class FraudulentActivity {
    static int activityNotifications(int[] expen, int d) {
        int notifications = 0,c=0;
        double med = 0;

        for(int i=0; i<expen.length; i++) {
            if(i+d >= expen.length)
                break;

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -1 * o1.compareTo(o2));
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for(int j=i; j<i+d; j++) {
                addNumber(expen[j], maxHeap, minHeap);
                rebalance(maxHeap, minHeap);
            }
            med = getMedian(maxHeap, minHeap);

            if(expen[d+i] >= 2*med) {
                notifications++;
            }
        }
        return notifications;
    }

    public static PriorityQueue<Integer> biggerHeap(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        return maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
    }

    public static PriorityQueue<Integer> smallerHeap(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        return maxHeap.size() < minHeap.size() ? maxHeap : minHeap;
    }

    public static void addNumber(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(maxHeap.size() == 0 || num < maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
    }

    public static void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> biggerHeap = biggerHeap(maxHeap, minHeap);
        PriorityQueue<Integer> smallerHeap = smallerHeap(maxHeap, minHeap);

        if(biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> biggerHeap = biggerHeap(maxHeap, minHeap);
        PriorityQueue<Integer> smallerHeap = smallerHeap(maxHeap, minHeap);

        if(biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String[] dn = Sc.nextLine().split(" ");

        int n = Integer.parseInt(dn[0]);
        int d = Integer.parseInt(dn[1]);

        String[] ex = Sc.nextLine().split(" ");


        int[] expen = new int[n];
        for(int i=0; i<n; i++) {
            expen[i] = Integer.parseInt(ex[i]);
        }

        System.out.print(activityNotifications(expen, d));
    }
}