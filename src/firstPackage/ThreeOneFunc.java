package firstPackage;


public class ThreeOneFunc {

    public static void main(String[] args) {
        MyFunction func = (x -> {
           return (float)(Math.cos(Math.pow(x,5)) + Math.pow(x, 4) - 345.3f*x - 23);
        });

        System.out.println(func.getResultWithParam(2));

        System.out.println(findRoot(func, 0, 10, 0.0001f));;


    }
    public static float findRoot(MyFunction func, float low, float high, float akk){
        FloatRange range = new FloatRange(low, high);
        return findRoot(func, range, akk);
    }

    public static float findRoot(MyFunction func, FloatRange range, float akk){
        float middlepoint = (range.lowrange+range.upperRagne)/2;
        if (range.getRange()<akk) return middlepoint;

        float low = func.getResultWithParam(range.lowrange);
        float middle = func.getResultWithParam(middlepoint);
        float high = func.getResultWithParam(range.upperRagne);

        if (middle == 0) return middle;

        if(!isSameSign(low, middle)){
            FloatRange newRange = new FloatRange(range.lowrange, middlepoint);
            return findRoot(func, newRange, akk);
        } else {
            FloatRange newRange = new FloatRange(middlepoint, range.upperRagne);
            return findRoot(func, newRange, akk);
        }
    }

    public static boolean isSameSign(float a, float b){
        if ((a<0 && b<0) || (a>0 && b>0)) return true;
        else return false;
    }






}
