package Eight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomic {

    public static void main(String[] args) {

        AtomicInteger atomInt = new AtomicInteger(0);
        AtomicInteger justInt = new AtomicInteger(0);

        Runnable runTwo = new Runnable() {
            @Override
            public void run() {
                justInt.incrementAndGet();
            }
        };


        Runnable run = () -> {
            atomInt.incrementAndGet();
            //justInt++;
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 1000; i++){
            executor.submit(run);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
            System.out.println(atomInt);
            System.out.println(justInt);

        } catch (InterruptedException e) {}

    }

}
