package warmup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JumpingClouds {
    public static void main(String... args){
        int arr [] = new int[]{0,0,1,0,0,1,0};
        List<Integer> c = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(jumpingOnClouds(c));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int jump=0;
        for(int i=0; i<=c.size()-2;){ //1,1,1,1
            if(i+2<c.size() && c.get(i+2)==0){
                jump++;
                i=i+2;
            }else if(i+1<c.size() && c.get(i+1)==0){
                jump++;
                i++;
            }
        }
        return jump;
    }

}
