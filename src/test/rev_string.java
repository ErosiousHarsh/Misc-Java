package test;

import java.util.*;

public class rev_string {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        String  s = Sc.nextLine();

        StringBuilder rev_s = new StringBuilder(s);

        System.out.print(rev_s.reverse());
    }
}
