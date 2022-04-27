package firstPackage;

import java.util.ArrayList;

public class OneThreeDeleteFromArray {

    public static void main(String[] args) {
        int[] arr = RandomArray.getIntRandomArray(10,5);
        int toRemove = 3;

        System.out.println("Initial array size: " + arr.length);
        System.out.println("Initial array: ");
        for (int i: arr
             ) {
            System.out.println(i);
        }

        arr = removeInt(toRemove, arr);

        System.out.println("Updated array size: " + arr.length);
        System.out.println("Updated array array: ");

        for (int i: arr
        ) {
            System.out.println(i);
        }




    }

    private static int[] removeInt(int value, int[] array){
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if(array[i] != value ) newArray.add(Integer.valueOf(array[i]));
        }
        int[] returnArray = new int[newArray.size()];
        for (int i = 0; i < returnArray.length; i++) returnArray[i] = newArray.get(i).intValue();
        return returnArray;
    }




}
