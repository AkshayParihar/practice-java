package strings;

import java.util.Arrays;
import java.util.Optional;

public class SpecialString {
    //All of the characters are the same, e.g. aaa.
    //All characters except the middle one are the same, e.g. aadaa.
    public static void main(String... args){
        String s = "mnonopoo";
        int n=s.length();
        System.out.println(substrCount(n,s));
    }

    //Number of substring from s string of length n :: n(n+1)/2
    //Number of unique substrings :: n(n-1)/2

    static long substrCount(int n, String s) {
        int repeat = 0;
        int ans = s.length();
        for(int i=0; i<s.length(); i++) {

            while ( i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1) ) {
                repeat++;
                i++;
            }
            ans += ((repeat) * (repeat + 1)) / 2;
            int pointer = 1;
            while (i - pointer >= 0 && i + pointer < s.length() && s.charAt(i + pointer) == s.charAt(i - 1) && s.charAt(i - pointer) == s.charAt(i - 1)) {
                ans++;
                pointer++;
            }
        }
        return ans;
    }
}
