package firstPackage;

public class RandomArray {

    public static int[] getIntRandomArray (int arraySize,int maxValue, int minValue){
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            array[i] = (int)(Math.random()*(maxValue-minValue+1) + minValue);
        }
        return array;
    }

    public static int[] getIntRandomArray (int arraySize,int maxValue){
        int[] array = getIntRandomArray(arraySize, maxValue, 0);

        return array;
    }

    public static float[] getFloatRandomArray (int arraySize,float maxValue, float minValue){
        float[] array = new float[arraySize];
        for (int i = 0; i < arraySize; i++){
            array[i] = (float) (Math.random()*(maxValue-minValue) + minValue);
        }
        return array;
    }

    public static float[] getFloatRandomArray (int arraySize,float maxValue){
        float[] array = getFloatRandomArray(arraySize,  maxValue, 0);
        return array;
    }

    public static float randomFloat(float min, float max){
        return (float) (Math.random()*(max-min)+min);
    }

    public static int randomInt(int min, int max){
        return (int) (Math.random()*(max-min)+min+1);
    }

}
