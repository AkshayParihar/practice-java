import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FraudDetection {
    public static void main(String... args){
        //int input[] = {2,3,4,2,3,6,8,4,5};
        //int d=5;
        int input[] = {1,2,3,4,4};
        int d=4;
        List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());
        System.out.println(activityNotifications(list,d));
    }

    private static int activityNotifications(List<Integer> expenditure, int d) {
        int arr[] = expenditure.stream().mapToInt(i->i).toArray();
        int count=0;
        int[] countSort = new int[201];
        for(int idx=0; idx<d-1; idx++){
            countSort[arr[idx]]++;
        }
        int leftMostIndex=-1;
        for(int i = 0; i<arr.length-d;i++){
            leftMostIndex = updateCountSortArray(countSort,arr, i, d, leftMostIndex);
            double median = getMedian(d,countSort);
            System.out.println("Median: "+median);
            System.out.println("arr[i+d]: "+arr[i+d]);
            if(arr[i+d]>=2*median){
                count++;
            }
        }
        return count;
    }

    private static double getMedian(int d, int[] countSort) {
        int sum=0;
        if(d%2!=0){
            int idx;
            for(idx=0;idx<countSort.length;idx++){
                sum+=countSort[idx];
                if(sum>d/2){
                    break;
                }
            }
            return idx;
        }else{
            int idx;
            Integer m1 = null, m2 = null;
            for(idx=0;idx<countSort.length;idx++){
                sum+=countSort[idx];
                if(m1==null && sum >= (d/2)){
                    m1=idx;
                }
                if(m2==null && sum >= (d/2)+1){
                    m2=idx;
                }
                if(m1!=null && m2!=null){
                    break;
                }
            }
            return (m1+m2)/2.0;
        }
    }

    private static int updateCountSortArray(int[] countSort, int[] arr, int i, int d, int leftMostIndex) {
        if(leftMostIndex != -1){
            countSort[arr[leftMostIndex]]--;
            arr[leftMostIndex]=-1;
        }
        countSort[arr[i+d-1]]++;
        return i;
    }


}
