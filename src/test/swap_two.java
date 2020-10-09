package test;

import java.util.*;

public class swap_two {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        int a = Sc.nextInt();
        int b = Sc.nextInt();

        a += b;
        b = a - b;
        a -= b;

        System.out.print(a+" "+b);
    }
}
