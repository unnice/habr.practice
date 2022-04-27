package Eight;

import java.util.concurrent.Semaphore;

public class MySemaphore {

    public static void main(String[] args) {

        /*Semaphore sem = new Semaphore(1, true);

        for (int i = 0; i<5; i++){
            Thread thread = new Thread(new SemaTest(sem));
            thread.start();
        }
        */


        Semaphore semPhil = new Semaphore(5);

        for (int i = 0; i<10; i++){
            Philosopher phil = new Philosopher(semPhil,"philosopher #" + String.valueOf(i));
            phil.start();
        }


    }



}

class SemaTest implements Runnable{

    private Semaphore sem;

    public SemaTest(Semaphore sem){
        this.sem = sem;
    }

    public void run(){
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Waiting for request");
            sem.acquire();
            System.out.println(threadName + ": tralala");
            Thread.sleep(500);
            sem.release();
        }catch (InterruptedException e){}
    }

}

class Philosopher extends Thread{

    Semaphore sem;
    int meals = 1;
    String name;

    public Philosopher (Semaphore sem, String name){
        this.sem = sem;
        this.name = name;
    }



    @Override
    public void run() {
        while (meals<=3){
            try {
                System.out.println(name + ": i asked for free place at the table");
                sem.acquire();
                System.out.println(name + ": I'm eating");
                Thread.sleep(500);
                System.out.println(name + ": I've finished my" + meals + " meal");
                meals++;
                sem.release();
            } catch (InterruptedException e){}
        }

    }
}
