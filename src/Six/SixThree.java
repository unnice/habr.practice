package Six;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class SixThree {

    interface Filter<T>{
        boolean apply(T t);
    }

    public static <T> List<T> filter(List<T> list, Function<? super T, Boolean> filter){

        List<T> returnList = new ArrayList<>();
        for (T t: list
             ) {
            if (filter.apply(t)) returnList.add(t);
        }

        return returnList;
    }

    public static void main(String[] args){

        List<Integer> array = new ArrayList();
        array.add(4);
        array.add(8);
        array.add(9);
        array.add(5);
        array.add(9);

        List arr2 = filter(array, i -> !i.equals(9));
        System.out.println("trarara");

        List<String> stringArr = new LinkedList<>();
        stringArr.add("Kkukushka");
        stringArr.add("huy");
        stringArr.add("Kkukushka");
        stringArr.add("huy");
        stringArr.add("Kkukushka");

        List stringList = filter(stringArr, x -> {
           if (x.equals("huy")) return false;
           else return true;
        });

        System.out.println("trarara");

    }



}
