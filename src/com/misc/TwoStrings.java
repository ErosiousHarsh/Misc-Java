package com.misc;

import java.util.*;

public class TwoStrings {

    public static boolean check(String s1, String s2) {

        HashSet<Character> unique = new HashSet<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for(char c: c1){
            if(!unique.contains(c))
                unique.add(c);
        }

        for (char c : c2) {
            if (unique.contains(c))
                return true;
        }
        return false;
    }

    public static void main(String[]args) {
        Scanner Sc = new Scanner(System.in);

        StringBuilder result = new StringBuilder();

        int n = Sc.nextInt();
        Sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 0; i < n; i++) {
            String s1 = Sc.nextLine();
            String s2 = Sc.nextLine();

            result.append(check(s1, s2) ? "YES\n" : "NO\n");
        }

        System.out.print(result);
    }
}
