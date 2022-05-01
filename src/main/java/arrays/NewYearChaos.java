package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class NewYearChaos {
    public static void main(String... args){
        int [] arr = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        minimumBribes(list);
    }

    public static void minimumBribes(List<Integer> q) {
        int[] arr = q.stream().mapToInt(i->i).toArray();
        int bribe = 0;
        for(int i=arr.length-1; i>=0; i--){
            int index = i+1;
                if(arr[i] != index){
                    if(i-1>=0 && arr[i-1] == i+1){
                        bribe++;
                        swap(arr,i-1,i);
                    }else if(i-2>=0 && arr[i-2] == i+1){
                        bribe=bribe+2;
                        swap(arr,i-2,i-1);
                        swap(arr,i-1,i);
                    }else{
                        System.out.println("Too chaotic");
                        return;
                    }
                printArray(arr);
            }
        }
        System.out.println(bribe);
    }

    private static void printArray(int[] arr) {
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

}
