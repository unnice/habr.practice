package ShapesPackInterdace;

public class Cylinder implements SolidOfRevolutionIn {

    private double height;
    private double radius;

    public Cylinder(double height, double radius){

        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getRadius(){
        return radius;
    }

    @Override
    public double getVolume(){
        return Math.PI*getRadius()*getRadius()*height;
    }

}
