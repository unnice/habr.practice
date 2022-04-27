package Eight;

public class SynchroTest {

    public static void main(String... args){

        MyData count = new MyData(0);



        for (int i = 0; i<5; i++){
            Thread thread = new Thread(new MethSynchroTwo(count));
            thread.start();
        }

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){}
        System.out.println(count);

    }

}

class MethSynchro implements Runnable{

    MyData count;

    public MethSynchro(MyData count){
        this.count = count;
    }
    @Override
    public  void run() {
        synchronized (count){
            count.count = 0;
            for (int i = 0; i<5; i++){
                count.count++;
                System.out.println(Thread.currentThread().getName() + ": count = " + count.count);
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){}
            }
        }
    }
}


class MethSynchroTwo implements Runnable{

    MyData count;

    public MethSynchroTwo(MyData count){
        this.count = count;
    }
    @Override
    public  void run() {
        count.increase();
    }
}

class MyData{
    public int count;

    public MyData(int count){
        this.count = count;
    }

    public synchronized void increase(){
        count = 0;
        for (int i = 0; i<5; i++){
            count++;
            System.out.println(Thread.currentThread().getName() + ": count = " + count);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){}
        }
    }
}
