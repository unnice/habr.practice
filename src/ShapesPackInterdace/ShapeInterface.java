package ShapesPackInterdace;

interface ShapeInterface extends Comparable<ShapeInterface>{
    double getVolume();

    default int compareTo(ShapeInterface o) {
        if(getVolume() == o.getVolume()) return 0;
        else if(getVolume() < o.getVolume()) return -1;
        else return 1;
    }

}

