package Eight;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutors {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);


        Runnable run = () -> {System.out.println("I'm next!");};
        Callable<Integer> call = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            }  catch (InterruptedException e){}
            return 125;
        };

        Future<Integer> future = executor.submit(call);
        System.out.println(future.isDone());
        try {
            Integer result = future.get();
            System.out.println(result);

        }catch (InterruptedException e) {}
        catch (ExecutionException ex) {}


        Executor exec = Executors.newWorkStealingPool();

        List<Callable<String>> callList = Arrays.asList(
                () ->  "One",
                () ->  "Two",
                () ->  "Three",
                () ->  "Four"
                );






    }

}
