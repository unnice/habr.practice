package firstPackage;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeZeroSearch {

    public static void main(String... args){
        int[] arr = RandomArray.getIntRandomArray(10000,5000,-5000);
        Arrays.sort(arr);
        int toFind = 596;

        Long time1 = System.currentTimeMillis();
        int index = containsWithRange(arr, toFind);
        time1 = System.currentTimeMillis() - time1;

        Long time2 = System.currentTimeMillis();
        int index2 = bruteSearch(arr, toFind);
        time2 = System.currentTimeMillis() - time2;


        System.out.println("Brutesearch = " + time2);
        System.out.println("Devide by 2 search = " + time1);
        System.out.println("Index brute = " + index2);
        System.out.println("Index devide = " + index);




        if(index>=0) System.out.println("Match: "+ arr[index] + " at index :" + index);

        //System.out.println("Result index is :" + index);

    }

    public static int bruteSearch(int[] arr, int x){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) return i;
        }
        return -1;
    }

    public static int containsWithRange(int[] arr, int x){
        Range range = new Range(0, arr.length-1);
        return containsWithRange(arr, range, x);
    }

    public static int containsWithRange(int[] arr, Range range, int x){
        System.out.println(range);
        if (range.getRange() <= 1){
            if(arr[range.lowrange] == x) return range.lowrange;
            if(arr[range.upperRagne] == x) return range.upperRagne;
            return -1;
        }

        int result;
        Range newRange = new Range(0, 0);
        int middleIndex = (range.lowrange + range.upperRagne)/2;
        result = arr[middleIndex];
        if (result == x) return middleIndex;

        if (result < x){
            newRange.upperRagne = range.upperRagne;
            newRange.lowrange = middleIndex;
        }

        if (result > x){
            newRange.upperRagne = middleIndex;
            newRange.lowrange = range.lowrange;
        }
        return containsWithRange(arr, newRange, x);
    }





}

class Range{
    int lowrange;
    int upperRagne;

    public Range(int lower, int upper){
        this.lowrange = lower;
        this.upperRagne = upper;
    }

    public int getRange(){
        return upperRagne-lowrange;
    }

    public String toString(){
        return "The range is from " + lowrange + " to " + upperRagne;
    }
}

class FloatRange{
    float lowrange;
    float upperRagne;

    public FloatRange(float lower, float upper){
        this.lowrange = lower;
        this.upperRagne = upper;
    }

    public float getRange(){
        return upperRagne-lowrange;
    }

    public String toString(){
        return "The range is from " + lowrange + " to " + upperRagne;
    }
}
