package MyAnnotation;

public class AnnotationClass {

    public static void main(String[] args) {

    }
}

abstract class  Parent {
    public abstract void printName();
}

class Child extends Parent{


    public  void printName(){
        System.out.println("MyName Is child");
    }
}

