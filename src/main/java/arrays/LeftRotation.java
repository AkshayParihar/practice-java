package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {
    public static void main(String... args){
        int[] arr = new int[]{1,2,3,4,5};
        int rotations=4;
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> result = rotLeft(list,rotations);
        for(Integer i: result){
            System.out.print(i+" ");
        }
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        while(d>0){
            int temp = a.get(0);
            a.remove(0);
            a.add(a.size(),temp);
            d--;
        }
        return a;
    }
}
