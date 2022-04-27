package ShapesPack;

import java.util.ArrayList;

public class Box extends Shape{
    ArrayList<Shape> shapes;
    private double avaliable;
    private double volume;

    public Box(double avalaible){
        this.avaliable = avalaible;
        this.volume = avalaible;
    }

    public boolean add(Shape shape){
        if(avaliable >=  shape.getVolume()){
            avaliable -= shape.getVolume();
            shapes.add(shape);
            return true;
        } else return false;

    }

    @Override
    public double getVolume(){
        return volume;
    }


}
