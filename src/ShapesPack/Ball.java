package ShapesPack;

public class Ball extends SolidOfRevolution{

    public Ball(double radius){
        super(radius);
    }

    public double getVolume(){
        return  4/3*Math.PI*Math.pow(getRadius(), 3);
    }

}
