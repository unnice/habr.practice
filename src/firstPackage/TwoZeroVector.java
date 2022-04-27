package firstPackage;

import java.awt.print.Printable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public final class  TwoZeroVector {

    private float x;
    private float y;
    private float z;

    public static void main(String[] args) {

        TwoZeroVector[] arr = getRandomVectors(10);

        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    // constructor
    public TwoZeroVector(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // getters
    public float getX(){
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    // returns vector module
    public float getModule()
    {
        return (float) Math.sqrt(x*x+y*y+z*z);
    }

    // returns vectors vect multiplication
    public static float getVectMult(TwoZeroVector first, TwoZeroVector second)
    {
        return first.x*second.x + first.y*second.y + first.z* second.z;
    }

    // returns angle between two vectors
    public static float getAngleRadForTwoVectors(TwoZeroVector first, TwoZeroVector second){

        float vect = getVectMult(first, second);
        return (float) Math.acos(vect/(first.getModule()*second.getModule()));

    }

    // returns vectors skalar multiplication
    public static TwoZeroVector getVectSkal(TwoZeroVector a, TwoZeroVector b){
        return new TwoZeroVector(a.z*b.y-a.y*b.z, a.x* b.z-a.z*b.x, a.y*b.x-a.x*b.y);
    }

    // returns summ of two vetctors
    public static TwoZeroVector vectSumm(TwoZeroVector a, TwoZeroVector b){
        return new TwoZeroVector(a.x+b.x, a.y+b.y, a.z+b.z);
    }

    //returns vectors substraction
    public static TwoZeroVector vectSubstract(TwoZeroVector a, TwoZeroVector b){
        return new TwoZeroVector(a.x-b.x, a.y-b.y, a.z-b.z);
    }

    //returns array of random vectors
    public static TwoZeroVector[] getRandomVectors(int size){
        TwoZeroVector[] arr = new TwoZeroVector[size];
        for (int i = 0; i < size; i++){
            TwoZeroVector vect = new TwoZeroVector(RandomArray.randomFloat(-10f,10f),
                                                   RandomArray.randomFloat(-10f,10f),
                                                   RandomArray.randomFloat(-10f,10f));
            arr[i] = vect;
        }
        return arr;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        String xS = df.format(x);
        String yS = df.format(y);
        String zS = df.format(z);
        String modS = df.format(getModule());

        String str = new String("X: " + xS  + "  Y: " + yS + " Z: " + zS + "\n" + "Module: " + modS);
        return str;
    }
}
