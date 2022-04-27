package Eight;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        CommonRes res = new CommonRes(0);

        Thread threadObe = new Thread(new Counter(lock, res));
        Thread threadTwo = new Thread(new Counter(lock, res));

        threadObe.start();
        threadTwo.start();

    }

}

class Counter implements Runnable{

    ReentrantLock lock;
    CommonRes count;

    public Counter(ReentrantLock lock, CommonRes count){
        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {

        lock.lock();
        try {
            count.count = 0;
            for (int i = 0; i<5; i++){
                System.out.println(Thread.currentThread().getName() + ": count: " + count.count);
                count.count++;
            }
        } finally {
            lock.unlock();
        }
    }
}

class CommonRes{

    int count;

    public CommonRes(int i){
        count = i;
    }
}
