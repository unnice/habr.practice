package ShapesPackInterdace;

import firstPackage.MyFunction;

import java.util.function.Function;

public class ShapeRun {
    public static void main(String[] args) {
        MyFunction func = (float x) ->{
            return 1;
        };
        Function<Double, Double> func2 = x -> x*3;
        Function<Double, Double> func3 = x -> x/10;

        double res = func2.andThen(func3).apply(Double.valueOf(3));
        System.out.println(res);
        //System.out.println(func2.apply(Double.valueOf(0)));

        //FunkRevolve revolve = new FunkRevolve(0, 1, func);


       // System.out.println(revolve.getVolume());
    }



}
