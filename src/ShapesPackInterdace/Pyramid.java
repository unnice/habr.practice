package ShapesPackInterdace;

import java.awt.*;

public class Pyramid implements ShapeInterface {

    private double s;
    private double h;

    public Pyramid(double h, double s) {
        this.h = h;
        this.s = s;
    }

    @Override
    public double getVolume() {
        return h*s/3;
    }


}
