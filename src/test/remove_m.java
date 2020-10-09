package test;

import java.util.*;

public class remove_m {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String str = Sc.nextLine();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'm')
                str = str.substring(0,i)+str.substring(i+1);
        }

        System.out.println(str);
    }
}
