package firstPackage;

public class Sorting {

    public static void main(String[] args) {

        int arraySize = 100;
        int[] array = RandomArray.getIntRandomArray(arraySize, 100);


        for (int i:array
             ) {
            System.out.println(i);
        }
        System.out.println("\n");

        /*
        boolean isSwapped = true;
        while (isSwapped){
            isSwapped = false;
            for (int i = 0; i<arraySize-1; i++){
                int swap = 0;
                if (array[i] > array[i+1]) {

                    swap = array[i];
                    array[i]=array[i+1];
                    array[i+1] = swap;
                    isSwapped = true;
                }
            }
        }
        */ //bad bublesort

        for (int i = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize-i-1; j++){
                if (array[j]>array[j+1]){
                    int swap = 0;
                    swap = array[j];
                    array[j]=array[j+1];
                    array[j+1] = swap;
                }

            }
        }


        for (int i:array
        ) {
            System.out.println(i);
        }


    }


}
