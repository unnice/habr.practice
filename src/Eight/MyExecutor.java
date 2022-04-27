package Eight;

import java.util.concurrent.Executor;

public class MyExecutor {

    public static void main(String... args){


        Runnable run = () -> {
            System.out.println("Executed");
        };

        Executor exec = (runnable) -> {
            new Thread(runnable).start();
        };

        exec.execute(run);




    }

}
