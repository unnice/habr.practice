package Eight;

import java.util.concurrent.Exchanger;

public class MyExchanger {

    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String first =  ex.exchange("Tralala");
                    System.out.println("First : " + first);


                }catch (InterruptedException e){}
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String second =  ex.exchange("trululu");
                    System.out.println("Second: " + second);


                }catch (InterruptedException e){}
            }
        });

        thread.start();
        threadTwo.start();

    }





}
