package com.misc;

import java.util.Arrays;
import java.util.Scanner;

class FaudulentActivity {
    static int activityNotifications(int[] expen, int d) {
        int notifications = 0,c=0;
        float median = 0f;

        for(int i=0; i<expen.length; i++) {
            if(i+d >= expen.length)
                break;

            c=0;
            int[] sub_expen = new int[d];
            for(int j=i; j<i+d; j++) {
                sub_expen[c] = expen[j];
                c++;
            }
            Arrays.sort(sub_expen);

            if(d%2 == 0)
                median = ((float) sub_expen[(d / 2) - 1] + (float) sub_expen[(d / 2)]) / 2f;
            else {
                int mid = d/2;
                median = sub_expen[mid];
            }

            if(expen[d+i] >= 2*median && expen[d+i] >= (int)(2*median)) {
                notifications++;
            }
        }
        return notifications;
    }
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String[] dn = new String[2];
        dn = Sc.nextLine().split(" ");

        int n = Integer.parseInt(dn[0]);
        int d = Integer.parseInt(dn[1]);

        String[] ex = new String[d];
        ex = Sc.nextLine().split(" ");

        int[] expen = new int[n];
        for(int i=0; i<n; i++) {
            expen[i] = Integer.parseInt(ex[i]);
        }

        System.out.print(activityNotifications(expen, d));
    }
}
