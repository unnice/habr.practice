package Eight;

import javax.sound.midi.Soundbank;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class EightOne {

    public static void main(String[] args)  {

        Semaphore sem = new Semaphore(1, true);
        Object obj = new Object();
        Boolean boolLock = true;
        ReentrantLock lock = new ReentrantLock();

        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 5; i++){
                    synchronized (boolLock){
                        try {

                            if(boolLock){
                                boolLock.wait();
                            }

                        }catch (InterruptedException e){}
                    }





                }

            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 5; i++){

                        try {

                            lock.lock();
                            System.out.println("My name is Bill");
                            lock.unlock();
                            Thread.sleep(100);
                        }catch (InterruptedException e){}


                }

            }
        });

        one.start();
        two.start();



    }


}
