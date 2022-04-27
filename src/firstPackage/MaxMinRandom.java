package firstPackage;

import java.text.DecimalFormat;
import java.util.Random;

public class MaxMinRandom {

    public static void main(String[] args){

        int arraySize = 20;
        int maxValue = 100;
        int minValue = 0;
        float currentMin = (float) maxValue;
        float currentMax = (float) minValue;
        int currentIntMax = maxValue;
        int currentIntMin = minValue;
        float[] arr = new float[arraySize];
        int[] intArr = new int[arraySize];
        float avr = 0;
        float intAvr = 0;
        DecimalFormat df = new DecimalFormat("#.##");




        // filling array with randoms
        for (int i = 0; i < arr.length; i++){

            Random rand = new Random();
            arr[i] = rand.nextFloat()*maxValue + minValue;
            intArr[i] = (int) (Math.random()*(maxValue-minValue) + 1 + minValue);

        }

        //printing array

        System.out.println("Float array: ");
        for (float i :arr
             ) {
            System.out.println(df.format(i));
        }

        System.out.println("Integer array: ");
        for (int i = 0; i < arraySize; i++){
            System.out.println(df.format(intArr[i]));
        }

        //searching for min and max value and intermediate;


        for (int i = 0; i < arr.length; i++){
            float current = arr[i];
            int intCurrent = intArr[i];

            if (current > currentMax) currentMax = current;
            if (current < currentMin) currentMin = current;

            if (intCurrent > currentIntMax) currentIntMax = intCurrent;
            if (intCurrent < currentIntMin) currentIntMin = intCurrent;

            avr += current;
            intAvr += intCurrent;
        }

        avr = avr / arraySize;
        intAvr = intAvr / arraySize;

        System.out.println("Min value = " + df.format(currentMin));
        System.out.println("Max value = " + df.format(currentMax));
        System.out.println("Average float = " + df.format(avr));
        System.out.println("Average integer Array = " + df.format(intAvr));


    }




}
