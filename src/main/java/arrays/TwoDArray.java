package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoDArray {
    public static void main(String... args){
        List<Integer> row;
        List<List<Integer>> rows = new ArrayList<>();
        int[] rowArr = new int[]{1,1,1,0,0,0};
        row = Arrays.stream(rowArr).boxed().collect(Collectors.toList());
        rows.add(row);
        rowArr = new int[]{0,1,0,0,0,0};
        row = Arrays.stream(rowArr).boxed().collect(Collectors.toList());
        rows.add(row);
        rowArr = new int[]{1,1,1,0,0,0};
        row = Arrays.stream(rowArr).boxed().collect(Collectors.toList());
        rows.add(row);
        rowArr = new int[]{0,0,2,4,4,0};
        row = Arrays.stream(rowArr).boxed().collect(Collectors.toList());
        rows.add(row);
        rowArr = new int[]{0,0,0,2,0,0};
        row = Arrays.stream(rowArr).boxed().collect(Collectors.toList());
        rows.add(row);
        rowArr = new int[]{0,0,1,2,4,0};
        row = Arrays.stream(rowArr).boxed().collect(Collectors.toList());
        rows.add(row);
        System.out.println(hourglassSum(rows));
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int[][] array = new int[6][6];
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                array[i][j] = arr.get(i).get(j);
            }
        }
        int sum=-64;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                int sumCalc = sum(array[i][j],array[i][j+1],array[i][j+2],array[i+1][j+1],array[i+2][j],array[i+2][j+1],array[i+2][j+2]);
                if(sumCalc>sum){
                    sum=sumCalc;
                }
            }
        }
        return sum;
    }

    public static int sum(int a, int b, int c, int d, int e, int f, int g){
        printHourGlass(a,b,c,d,e,f,g);
        return a+b+c+d+e+f+g;
    }

    private static void printHourGlass(int a, int b, int c, int d, int e, int f, int g) {
        System.out.print(a+" "+b+" "+c+"\n");
        System.out.print("  "+d+"  \n");
        System.out.print(e+" "+f+" "+g+"\n\n");
    }
}
