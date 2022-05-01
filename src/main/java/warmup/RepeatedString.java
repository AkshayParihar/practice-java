package warmup;

public class RepeatedString {
    public static void main(String... args){
        String s = "aba";
        long n = 10;
        System.out.println(repeatedString(s,n));
    }

    public static long repeatedString(String s, long n) {
        long count=0;
        long minNumFullString = n/s.length();
        long remainingCharacters = n%s.length();
        if(s.length()>=n){
            for(int i=0; i<n; i++){
                if('a' == s.charAt(i)) count++;
            }
            return count;
        }else {
            for (int i = 0; i < s.length(); i++) {
                if ('a' == s.charAt(i)) count++;
            }
            if (minNumFullString > 0) {
                count = count * minNumFullString;
            }
            if (remainingCharacters > 0) {
                for (int i = 0; i < remainingCharacters; i++) {
                    if ('a' == s.charAt(i)) count++;
                }
            }
            return count;
        }
    }
}
