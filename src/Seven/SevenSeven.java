package Seven;

import java.util.HashMap;
import java.util.Map;

public class SevenSeven {



    private static <K> Map<K, Integer> countElements(K[] array){

        HashMap<K, Integer> map = new HashMap<>();

        for (int i = 0; i<array.length; i++){
            if (map.containsKey(array[i])){
                map.compute(array[i], (k, v) -> {
                   return v++;
                });
            } else map.put(array[i], 1);
        }


        return null;
    }


}
