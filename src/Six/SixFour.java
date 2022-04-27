package Six;

import java.util.function.Function;

public class SixFour {

    public static <T> void fill(T[] arr, Function<Integer, T> func){
        for (int i = 0; i < arr.length; i++){

            arr[i] = func.apply(i);


        }
    }

}
