package com.misc;

import java.util.*;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        boolean check = true;

        HashMap<String, Integer> mag_count = new HashMap<>();
        for(String c: magazine) {
            mag_count.put(c, mag_count.getOrDefault(c, 0)+1);
        }

        for(String c: note) {
            if(!mag_count.containsKey(c) || mag_count.get(c) <= 0) {
                check = false;
                break;
            }
            mag_count.put(c, mag_count.get(c) -1);
        }
        System.out.println((check) ? "Yes" : "No");

    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String[] mn = Sc.nextLine().split(" "); // taking input and storing in 'm' and 'n'

        int m = Integer.parseInt(mn[0]);
        String[] magazine = new String[m];

        int n = Integer.parseInt(mn[1]);
        String[] note = new String[n];

        String[] magazineArray = Sc.nextLine().split(" ");
        Sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (m >= 0) System.arraycopy(magazineArray, 0, magazine, 0, m);

        String[] noteArray = Sc.nextLine().split(" ");
        if (n >= 0) System.arraycopy(noteArray, 0, note, 0, n);

        checkMagazine(magazine, note);
    }
}
