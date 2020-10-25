package com.misc;

import java.util.Scanner;

public class MergeSortCountingInversions {
    protected static int count = 0;
    static long inversions(int[] arr) {
        mergeSort(arr, new int[arr.length], 0 ,arr.length-1);
        return count;
    }
    static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd)
            return;
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, mid);
        mergeSort(arr, temp, mid+1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);
    }
    static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        int index = leftStart;

        int left = leftStart;
        int right = rightStart;

        while(left <= leftEnd && right <= rightEnd) {
            if(arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;

                count += 1;
            }
            index++;
        }
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }
    public static void main(String[] args) {
        var Sc = new Scanner(System.in);

        StringBuilder out = new StringBuilder();

        int n = Sc.nextInt();
        Sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i=1; i<=n; i++) {
            int l = Sc.nextInt();
            Sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[l];

            String[] str = Sc.nextLine().split(" ");

            for(int j=0; j<l; j++) {
                int temp = Integer.parseInt(str[j]);
                arr[j] = temp;
            }
            out.append(inversions(arr)).append("\n");
        }
        System.out.print(out);
    }
}
