package warmup;

// path= "UDDDUDUU"
//The hiker first enters a valley  units deep.
// Then they climb out and up onto a mountain  units high.
// Finally, the hiker returns to sea level and ends the hike.

public class ValleysTravelled {
    public static void main(String... args){
        String path= "UDDDUDUU";
        int steps = path.length();
        System.out.println(countingValleys(steps,path));
    }
    public static int countingValleys(int steps, String path) {
        int valley=0;
        int state=0;
        for(char ch : path.toCharArray()){
            if('U' == ch){
                state++;
            }else{
                state--;
                if(state==-1){
                    valley++;
                }
            }
        }
        return valley;
    }
}
