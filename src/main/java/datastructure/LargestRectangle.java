package datastructure;

import java.util.ArrayList;
import java.util.List;

public class LargestRectangle {
    public static void main(String... args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(largestRectangle(list));
    }

    public static long largestRectangle(List<Integer> h) {
        int min=0;
        for(int i=0; i< h.size();i++){
            if(i==0){
                min = h.get(i);
                continue;
            }else{
                if(h.get(i)<min){
                    min = h.get(i);
                }
            }
        }
        return min*h.size();
    }

}