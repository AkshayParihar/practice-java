package strings;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SherlockValidString {
    public static void main(String... args){
        String s = "aabbcdd";
        System.out.println(isValid(s));
    }

    public static String isValid(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, Optional.ofNullable(map.get(ch)).orElse(0)+1);
        }
        Integer oldNum=null, newNum;
        boolean deducted=false, prevMatch=false;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()==1 && !deducted){
                deducted=true;
                prevMatch=true;
            }else {
                if (null == oldNum) {
                    oldNum = entry.getValue();
                } else {
                    newNum = entry.getValue();
                    if (!oldNum.equals(newNum)) {
                        if (deducted) {
                            return "NO";
                        } else {
                            if (oldNum - 1 != newNum && oldNum != newNum - 1) {
                                return "NO";
                            } else {
                                if (prevMatch && oldNum - 1 == newNum) {
                                    return "NO";
                                } else {
                                    if (newNum - 1 == oldNum) {
                                        newNum = newNum - 1;
                                    }
                                }
                                prevMatch = true;
                            }
                            deducted = true;
                        }
                    } else {
                        prevMatch = true;
                    }
                    oldNum = newNum;
                }
            }
        }
        return "YES";
    }
}
