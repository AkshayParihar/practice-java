package arrays;

import java.util.List;

public class MinimumSwaps2 {
    public static void main(String... args){
        int[] arr = new int[]{7,1,3,2,4,5,6};
        System.out.println(minimumSwaps(arr));
    }

    public static int minimumSwaps(int[] arr) {
        int count=0;
        int n=arr.length;
        int i=0;
        int temp;
        while(i<n){
            if(arr[i] != i+1){
                temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1]=temp;
                count++;
            }else{
                i++;
            }
        }
        return count;
    }
}
