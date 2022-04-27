package firstPackage;

import java.util.Arrays;

public class TwoOneWeight {

    private int[] arr;
    private int[] weight;
    private int[] arrayWeight;
    private int[] rangeArray;
    private int summ;

    public static void main(String[] args){

        int arrSize = 10;
        TwoOneWeight tw = new TwoOneWeight(RandomArray.getIntRandomArray(arrSize, 10, 0),
                                           RandomArray.getIntRandomArray(arrSize, 10, 0));

        for (int i=0; i < arrSize; i++){
            System.out.println("Base: " + tw.arr[i] + "  Weight: " + tw.weight[i] + "  Ranges: " + tw.rangeArray[i]);
        }
        System.out.println("Weightsumm = " + tw.summ);

        System.out.println("\n\n" + "Now there are random values with weight: ");
        for (int i = 0; i<10; i++){
            System.out.println(tw.getValueWithWeight() + "  " + tw.getValueWithWeightSecond());
        }

    }


    public TwoOneWeight(int[] arr, int[] weight){
        this.weight = weight;
        this.arr = arr;
        this.rangeArray = new int[arr.length];

        //Summ calculation
        int weightSumm = 0;
        for (int i = 0; i < arr.length; i++){
            weightSumm+=weight[i];
        }
        summ = weightSumm;

        //weight array calculation
        this.arrayWeight = new int[weightSumm];
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < weight[i]; j++){
                arrayWeight[k] = arr[i];
                k++;
            }
        }

        //range array calculation

        int bound = 0;
        for (int i = 0; i < arr.length; i++){
            bound = bound + weight[i];
            rangeArray[i] = bound;
        }


    }

    public int getValueWithWeight(){
        return arrayWeight[RandomArray.randomInt(0, arrayWeight.length-1)];
    }

    public int getValueWithWeightSecond(){
        int value = RandomArray.randomInt(0,summ-1);
        int index = Arrays.binarySearch(rangeArray, value);
        return arr[index>=0? index : -index];
    }

    public void printArrayWithWeight(){

    }

}
