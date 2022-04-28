package MyAnnotation;

import java.lang.annotation.*;
import java.util.List;

public class AnnotationClass {

    public static void main(String[] args) {



    }
}

@MyPreamble(
        Author = "Leha",
        version = 0.9f,
        CheckList = {"Elena", "Vasiliy", "Ivan"}
)
abstract class  Parent {
    public void printName(){
        System.out.println("My name is");
    }
}

class Child extends Parent{

    @Override
    public  void printName(){
        System.out.println("MyName Is child");
    }


}

@Documented
@interface MyPreamble {
    String Author();
    double version();
    String[] CheckList();
}



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface JsonSerialazible{
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonElement{
     String key() default "";
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Init{

}
