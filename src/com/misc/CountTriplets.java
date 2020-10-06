package com.misc;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CountTriplets {

    private static long countTriplets(List<Long> arr, long r) {
        HashMap<Long ,Integer> count = new HashMap<>();
        HashMap<Long ,Integer> check = new HashMap<>();

        for (Long aLong : arr) {
            count.put(aLong, count.getOrDefault(aLong, 0) + 1);
        }

        long c = 0;

        for (long mid : arr) {
            long c1 = 0, c3 = 0;

            count.put(mid, count.getOrDefault(mid, 0) - 1);

            if (check.containsKey(mid / r) && mid % r == 0)
                c1 = check.get(mid / r);
            if (count.containsKey(mid * r))
                c3 = count.get(mid * r);
            System.out.println(c + " += " + c1 + " * " + c3 + " = " + c1 * c3);
            c += c1 * c3;

            check.put(mid, check.getOrDefault(mid, 0) + 1);
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String[] nr = Sc.nextLine().split(" ");
        int n = Integer.parseInt(nr[0]);
        long r = Integer.parseInt(nr[1]);

        Sc.skip("(\n)?");

        List<Long> arr = Arrays.stream(Sc.nextLine().split(" ")).map(Long::parseLong).collect(toList());

        System.out.print(countTriplets(arr, r));

    }
}
