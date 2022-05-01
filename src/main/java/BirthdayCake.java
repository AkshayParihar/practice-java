import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayCake {
    public static void main(String... args){
        int[] inpt = {4,4,2,5,1,5,6,6,6};
        List<Integer> arr = Arrays.stream(inpt).boxed().collect(Collectors.toList());
        birthdayCake(arr);
    }

    private static void birthdayCake(List<Integer> arr) {
        int count=1;
        int max=0;
        for(Integer i: arr){
            if(max==i){
                count++;
            }else if(max<i){
                count=1;
                max=i;
            }
        }
        System.out.println(max+" "+count);
    }


}

// isBst(Node root, Node l, Node r)
// if root == null false
// if l!=null && l.data >= root.data
// if r!=null && r.data <= root.data
// return isBst(root.left,l,root) && isBst(root.right,root,r)