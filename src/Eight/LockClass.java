package Eight;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass {

    static class Bower{

        private final Lock lock = new ReentrantLock();

        public Bower(Bower friend){
            lock.unlock();
        }

        private boolean tryToBow(Bower friend){
            boolean myLock = lock.tryLock();
            boolean friendLock = friend.lock.tryLock();
            if(!(myLock && friendLock)){
                if(myLock) lock.unlock();
                if(friendLock) friend.lock.unlock();
            }
            return myLock&&friendLock;
        }

        private void bowToFriend(Bower friend){
            if(tryToBow(friend)){

            }



        }


    }

    public static void main(String[] args) {


        Lock lock = new ReentrantLock();
        Lock lockTwo = new ReentrantLock();

        Thread threadOne = new Thread(()->{
            lock.lock();
            System.out.println("I have started and locked lock");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){}
            System.out.println("Im going to unlock the lock");
            lock.unlock();
        });

        Thread threadTwo = new Thread(()->{
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}

            //System.out.println("I have waited for 1 sec and then tryed to get lock with result: ");
            //System.out.println(lock.tryLock());
            lock.lock();
            System.out.println("I have locked it!");
        });

        threadOne.start();
        threadTwo.start();



    }
}
