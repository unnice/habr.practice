package Seven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SevenEight {

    private static <K,V> Map<V,? extends Collection<K>> reverseKeysValues(Map<K, V> mainMap){

        HashMap<V, ArrayList<K>> map = new HashMap<>();
        for (Map.Entry<K,V> entry: mainMap.entrySet()
             ) {

            map.compute(entry.getValue(), (k, v) -> {
                if (v == null){
                    v = new ArrayList<>();
                    v.add(entry.getKey());
                } else {
                    v.add(entry.getKey());
                }
                return v;
            });



        }

        return map;

    }

}
