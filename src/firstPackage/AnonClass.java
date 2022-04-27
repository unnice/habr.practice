package firstPackage;

public class AnonClass {


    @FunctionalInterface
    interface MyInterface{
        public void saySomething(String str);
    }


    public static void doSomething(MyInterface inter, String s){
        inter.saySomething(s);
    }

    public static void main(String... args){

        MyInterface myInterface;
        myInterface = (String s) -> System.out.println(s);


        doSomething(new MyInterface() {
            @Override
            public void saySomething(String str) {
                System.out.println(str);
            }
        }, "bubu");
        doSomething((String s) -> System.out.println(s), "viva");





    }


    }




