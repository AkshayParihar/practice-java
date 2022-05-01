import java.util.HashMap;
import java.util.Map;

public class BiDirectionalMap<T,Q> extends HashMap<T,Q>{

    HashMap<Q,T> destinationMap = new HashMap<>();

    public T getKeyByValue(T value){
        return destinationMap.get(value);
    }

    @Override
    public Q put(T key, Q value){
        super.put(key,value);
        destinationMap.put(value,key);
        return value;
    }

}



// txns - name, date, amount
// >100000 past 30 days

//select name, sum(amount), max(date) from txns where date = BETWEEN(SYSDATE-30, SYSDATE) group by name having sum(amount)>100000;
//