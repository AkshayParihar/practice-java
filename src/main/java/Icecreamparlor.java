import java.util.*;
import java.util.stream.Collectors;

public class Icecreamparlor {
    public static void main(String... args){
        int[] inpt = {2,2,4,3};
        int m=4;
        List<Integer> arr = Arrays.stream(inpt).boxed().collect(Collectors.toList());
        List<Integer> result = icecreamParlor(m,arr);
        for(Integer i: result){
            System.out.println(i);
        }
    }
    //1-based index
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        int[] a=arr.stream().mapToInt(i->i).toArray();
        //cost for y, index of x
        Map<Integer,Integer> map = new HashMap<>();
        int idx=0;
        int x=0,y=0;
        for(int i: a){
            if(null==map.get(i)){
                map.put(m-i,idx);
            }else{
                y=idx;
                x=map.get(i);
            }
            idx++;
        }
        List<Integer> result = new ArrayList<>();
        result.add(Math.min(x,y)+1);
        result.add(Math.max(x,y)+1);
        return result;
    }
}
