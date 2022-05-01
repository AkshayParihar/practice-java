import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String... args){
        int[] input = {5,4,10,6,2};
        List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());
        bubbleSort(list);
        selectionSort(list);
        insertonSort(list);
        mergeSortInit(list);
        quickSortInit(list);
    }

    private static void quickSortInit(List<Integer> list) {
        int arr[] = list.stream().mapToInt(i->i).toArray();
        quickSort(arr,0,arr.length-1);
        printSortedArray("Quick Sort",arr);

    }

    private static void quickSort(int[] arr, int lb, int ub) {
        if(lb<ub){
            int location = partition(arr,lb,ub);
            quickSort(arr,lb,location-1);
            quickSort(arr,location+1,ub);
        }
    }

    private static int partition(int[] arr, int lb, int ub) {
        int key = arr[lb];
        int start = lb;
        int end = ub;
        while(start<end){
            while(key<=arr[start]){
                start++;
            }
            while(key>arr[end]){
                end--;
            }
            if(start<end){
                swap(arr,start,end);
            }
        }
            swap(arr,lb,end);
        return end;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void mergeSortInit(List<Integer> list) {
        int arr[] = list.stream().mapToInt(i->i).toArray();
        mergeSort(arr,0,arr.length-1);
        printSortedArray("Merge Sort",arr);

    }

    private static void mergeSort(int[] arr, int lb, int ub) {
        if(lb<ub) {
            int mid = (lb + ub) / 2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid + 1, ub);
            merge(arr,lb,mid,ub);
        }
    }

    private static void merge(int[] arr, int lb, int mid, int ub) {
        int i=lb;
        int j=mid+1;
        int k=lb;
        int[] newArr = new int[ub+1];
        //Iterate and start putting values in new Array
        while(i<=mid && j<=ub){
            if(arr[i]<=arr[j]){
                newArr[k]=arr[i];
                i++;
            }else{
                newArr[k]=arr[j];
                j++;
            }
            k++;
        }
        //There is a possibility that in j subsection of array there are few elements left. Copy them as is.
        if(i>mid){
            while(j<=ub){
                newArr[k]=arr[j];
                j++;
                k++;
            }
        }else{//There is a possibility that in i subsection of array there are few elements left. Copy them as is.
            while(i<=mid){
                newArr[k]=arr[i];
                i++;
                k++;
            }
        }
        //Copy new array to old
        for(int idx=lb; idx<=ub; idx++){
            arr[idx]=newArr[idx];
        }
    }

    private static void insertonSort(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        printSortedArray("Insertion Sort",arr);
    }

    private static void selectionSort(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printSortedArray("Selection Sort",arr);
    }

    private static void bubbleSort(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        for(int i=0;i<arr.length;i++){
            for(int j=1; j< arr.length;j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        printSortedArray("Bubble Sort",arr);
    }

    private static void printSortedArray(String sortName, int[] arr) {
        System.out.println(sortName);
        System.out.print("{ ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.print("}\n");
        System.out.println("----------------------");
    }

}
