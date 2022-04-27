package Eight;



public class WaitNotify {

    public synchronized static void main(String[] args) {

        Box box = new Box();

        Fuller fuller = new Fuller(box);
        Emptyer emptyer = new Emptyer(box);

        Thread threadOne = new Thread(fuller);
        Thread threadTwo = new Thread(emptyer);

        threadOne.start();
        threadTwo.start();


    }
}

class Box {
    public boolean isEmpty;

    public Box(){
        this.isEmpty = true;
    }

    public synchronized void setFull(){
        while (!isEmpty)
            try {
                wait();
            }catch (InterruptedException e){}
        System.out.println("The box is full now");
        isEmpty = false;
        notify();
    }

    public synchronized void setEmpty(){
        while (isEmpty){
            try {
                wait();
            }catch (InterruptedException e) {}
        }
        System.out.println("The box is empty now");
        isEmpty = true;
        notify();
    }
}

class Fuller implements Runnable{

    Box box;

    public Fuller(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i<5; i++){
            box.setFull();
            //System.out.println("Ive set it full for the :" + i + " time!");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
        }
    }
}

class Emptyer implements Runnable{

    Box box;

    public Emptyer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i<5; i++){
            box.setEmpty();
            //System.out.println("Ive eptyed for the :" + i + " time!");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
        }
    }
}

