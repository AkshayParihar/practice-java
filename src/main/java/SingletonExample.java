public class SingletonExample {

    static SingletonExample s = new SingletonExample();

    private SingletonExample(){

    }

    public synchronized static SingletonExample getInstance(){
        return s;
    }

}

class Impl{
    public static void main(String... args){
        int arr[] = new int[]{1,2,3,3,3,4};
        int key = 4;
        Integer startIndex=null,endIndex=null;
        for(int i=0; i<arr.length; i++){
            if(key==arr[i] && startIndex ==null){
                startIndex = i;
            }else if(key==arr[i]){
                endIndex = i;
            }
        }
        System.out.println(startIndex + "  " + endIndex);
    }
}


interface Num{
    int getNum(String a);
}
class Akshay{
    public static void main(){
        Num n = (a)->{return 1;};
        n.getNum("1");
    }
}

// Paytm -> Vendor1 (), V2 (), V3()
// API Endpoint management tool (Vendor Id , URL, Connecttimeout)
// Certificate management tool (Venafi)
// Secret management
// Proxy (Akamai) List {}

//arr[] {1,2,3,3,3,4}

class DS{

}






