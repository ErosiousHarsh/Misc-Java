package com.misc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class MarksAndToys {

    static int maximumToys(int[] new_prices, int k) {
        int toys = 0,c=new_prices.length;

        Arrays.sort(new_prices);

        for (int new_price : new_prices) {
            if (k >= new_price) {
                k -= new_price;
                toys += 1;
            }
        }
        return toys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.print(result);

        scanner.close();
    }
}
