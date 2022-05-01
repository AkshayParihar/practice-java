import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarkAndToys {
    public static void main(String... args){
        int[] input = {3,7,2,9,4};
        int budget = 15;
        List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());
        System.out.println(maximumToys(list,budget));
    }

    private static int maximumToys(List<Integer> list, int k) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(arr);
        int index=0;
        while(k>=0 && index<arr.length){
            k=k-arr[index];
            index++;
            System.out.println("k "+k);
            System.out.println("index "+index);
            System.out.println("arr[index] "+arr[index]);
        }
        return index;
    }
}
