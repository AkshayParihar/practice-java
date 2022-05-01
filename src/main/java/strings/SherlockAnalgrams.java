package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SherlockAnalgrams {

    public static void main(String... args){
        int a = sherlockAndAnagrams("abba");
        System.out.println(a);
    }

    private static int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            for(int j=i+1; j<=s.length(); j++){
                char[] subs = s.substring(i,j).toCharArray();
                Arrays.sort(subs);
                String subStr = new String(subs);
                map.put(subStr, Optional.ofNullable(map.get(subStr)).orElse(0)+1);
            }
        }
        int pairs=0;
        for(Map.Entry<String,Integer> e: map.entrySet()){
            pairs += (e.getValue()*e.getValue()-1)/2;
        }
        return pairs;
    }


}
