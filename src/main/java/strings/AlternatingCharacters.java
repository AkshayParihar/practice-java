package strings;

import java.util.Collection;

public class AlternatingCharacters {
    public static void main(String... args){
        String s="AAAABBA";
        int i = alternatingCharacters(s);
        System.out.println(i);
    }

    private static int alternatingCharacters(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        char current,next;
        for(int i=0; i< charArray.length-1; i++){
             next = charArray[i+1];
             current = charArray[i];
            if(next==current){
                count++;
            }
        }
        return count;
    }
}
