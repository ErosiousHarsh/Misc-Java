package com.misc;

import java.util.*;

public class SherlockAndAnagrams {

    private static int sherlock(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                char[] c = s.substring(i,j+1).toCharArray();
                String bs = new String(c);
                Arrays.sort(c);
                String str = new String(c);
                System.out.println("Before:"+ bs +"\tAfter:"+str);

                map.put(str, map.getOrDefault(str,0)+1);
            }
        }

        for(Map.Entry<String, Integer> e: map.entrySet()) {
            System.out.println(e.getKey() + "\t" + e.getValue());
        }

        int pairs = 0;
        for(String str: map.keySet()) {
            int v = map.get(str);
            pairs += (v * (v - 1)) / 2;
        }

        return pairs;
    }

    public static void main(String[]args) {
        Scanner Sc = new Scanner(System.in);

        StringBuilder result = new StringBuilder();

        int n = Sc.nextInt();
        Sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 0; i < n; i++) {
            String s = Sc.nextLine();

            result.append(sherlock(s)).append("\n");
        }
        System.out.print(result);
    }
}
