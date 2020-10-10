package com.misc;

import java.util.*;

public class RunningMedian {
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
    public static double[] getMedians(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -1 * o1.compareTo(o2));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double[] medians = new double[arr.length];

        for(int i: arr) {
            addNumber(arr[i], maxHeap, minHeap);
            rebalance(maxHeap, minHeap);
            medians[i] = getMedian(maxHeap, minHeap);
        }
        return medians;
    }
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String[] nd;
        nd = Sc.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        String[] ex = Sc.nextLine().split(" ");

        int[] expen = new int[n];
        for(int i=0; i<n; i++) {
            expen[i] = Integer.parseInt(ex[i]);
        }

        double[] medians = getMedians(expen);
        for(double i: medians){
            System.out.println(i);
        }
    }
}
