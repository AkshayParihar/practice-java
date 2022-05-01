import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinMax {

    public static void main(String... args){
        int[] inpt={9,5,3,1,7};
        List<Integer> arr = new ArrayList<>(Arrays.stream(inpt).boxed().collect(Collectors.toList()));
        miniMaxSum(arr);
    }



    public static void miniMaxSum(List<Integer> arr) {
        int[] input=arr.stream().mapToInt(i->i).toArray();

        for(int i=0;i<input.length;i++){
            for(int j=1;j<input.length-i;j++){
                if(input[j-1]>input[j]){
                    int temp = input[j];
                    input[j]=input[j-1];
                    input[j-1]=temp;
                }
            }
        }

        for(int i:input){
            System.out.println(i);
        }
        int min=0,max=0;
        for(int i=0;i<input.length;i++){
            if(i<=input.length-2){
                min+=input[i];
            }
            if(i>=1) {
                max += input[i];
            }
        }

        System.out.println(min+" "+max);

    }
}
