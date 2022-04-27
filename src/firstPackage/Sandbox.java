package firstPackage;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;

interface MyInterface{
    int myInt = 10;
}

abstract class MyAbstractClass{
    int myInt;

}

class Mygeneric<T>{
    T myObject;

    public void doSomethingWithMyObject(T t){
        System.out.println(t);
    }
}

public class Sandbox {

    public static void main(String[] args) {

        var myBool = true;
        var count = Integer.valueOf(10);


    }

}




