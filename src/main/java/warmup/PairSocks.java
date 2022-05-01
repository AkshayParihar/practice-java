package warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Given an array of integers representing the color of each sock,
// determine how many pairs of socks with matching colors there are.
public class PairSocks {
    public static void main(String... args){
        int n=7;
        int arr[]=new int[]{1,2,1,2,1,3,2};
        List<Integer> ar = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(sockMerchant(n,ar));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: ar){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int pairs=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pairs = pairs + entry.getValue()/2;
        }
        return pairs;
    }
}
