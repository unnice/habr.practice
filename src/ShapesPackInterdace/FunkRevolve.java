package ShapesPackInterdace;
import firstPackage.MyFunction;

import java.util.function.Function;


public class FunkRevolve implements ShapeInterface{

    double from;
    double  to;
    double accuracy;

    MyFunction func;

    public FunkRevolve(double from, double to, MyFunction func){
        this.func = func;
        this.from = from;
        this.to = to;

        if(from > to){
            this.to = from;
            this.from = to;
        }

        //if ((this.to - this.from)/50 > 0.1) accuracy = 0.1;
        accuracy = (this.to - this.from)/100;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getVolume(){
        double summ = 0;
        double current = from;
        double funcResult = 0;
        double curCylVolume = 0;
        while (true){
            if(current+accuracy>=to){
                funcResult = this.func.getResultWithParam((float) ((to - current)/2+current));
                curCylVolume = Math.PI*Math.pow(funcResult, 2)*((to - current));
                summ += curCylVolume;
                break;
            }
            funcResult = this.func.getResultWithParam((float) (current + accuracy/2));
            curCylVolume = Math.PI*Math.pow(funcResult, 2)*accuracy;
            summ += curCylVolume;

            current += accuracy;
        }
        return summ;
    }

}
