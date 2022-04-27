package ShapesPackInterdace;

import java.util.ArrayList;

public class Box implements ShapeInterface {
    ArrayList<ShapeInterface> shapes;
    private double avaliable;
    private double volume;

    public Box(double avalaible){
        this.avaliable = avalaible;
        this.volume = avalaible;
    }

    public boolean add(ShapeInterface shape){
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
