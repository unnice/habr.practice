package firstPackage;

import java.util.ArrayList;

public class ElementNumber {
    public static void main(String[] args) {

        int range = 1000;
        ArrayList<Integer> array = new ArrayList<>();
        array.add(Integer.valueOf(1));


        for (int i = 2; i<= range; i++){
            boolean isNotSimple = true;
            for (Integer a: array
                 ) {
                if ((i % a.intValue() == 0) && (i != a.intValue()) && (a.intValue() != 1)){
                    isNotSimple = false;
                    break;
                }

            }
            if(isNotSimple) array.add(Integer.valueOf(i));
        }
        for (Integer i: array
             ) {
            System.out.println("Simple value: " + i);

        }
    }




}
