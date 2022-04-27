package ShapesPackInterdace;

public class Ball implements SolidOfRevolutionIn {

    private double radius;

    public Ball(double radius){

        this.radius = radius;
    }

    public double getVolume(){
        return  4/3*Math.PI*Math.pow(getRadius(), 3);
    }

    public double getRadius(){
        return radius;
    }

}
