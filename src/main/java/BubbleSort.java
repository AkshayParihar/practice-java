import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String... args){
        int[] inpt = {3,2,1};
        List<Integer> arr = Arrays.stream(inpt).boxed().collect(Collectors.toList());
        countSwaps(arr);
    }

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int count=0;
        int[] arr = a.stream().mapToInt(i->i).toArray();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    count++;
                }
            }
        }
        System.out.println("Array is sorted in "+count+" swaps.");
        System.out.println("First Element: "+arr[0]);
        System.out.println("Last Element: "+arr[arr.length-1]);
    }

}
