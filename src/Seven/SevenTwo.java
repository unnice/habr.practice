package Seven;

import java.sql.Time;
import java.util.*;
import java.util.function.Consumer;


public class SevenTwo {

    public static void main(String[] args) {




        mycompare();
        compare2Lists();


    }

    public static void mycompare(){
        LinkedList<Double> list = new LinkedList<>();
        ArrayList<Double> array = new ArrayList<>();
        int size = 1000000;
        int times = 1000;
        final int N = 1000000;
        final int M = 1000;


        for(int i = 0; i< size; i++){
            list.add(Math.random());
            array.add(Math.random());
        }

        long time = System.currentTimeMillis();


        time = System.currentTimeMillis();
        for(int i = 0; i< times; i++){
            list.get((int)(Math.random()*(size-1)));
            //list.get((int) (Math.random() * (N - 1)));
        }
        System.out.println("Time of random get in LinkedList :" + (System.currentTimeMillis()-time));

        time = System.currentTimeMillis();
        for(int i = 0; i< times; i++){
            array.get((int)(Math.random()*size));

        }
        System.out.println("Time of random get in ArrayList :" + (System.currentTimeMillis()-time));
    }

    public static void compare2Lists() {
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        final int N = 1000000;
        final int M = 1000;
        for (int i = 0; i < N; i++) {
            arrayList.add(Math.random());
            linkedList.add(Math.random());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            arrayList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            linkedList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    class Myiter<T> implements Iterator{

        private List<T> list;
        private int index;

        public Myiter(List<T> list){
            this.list = list;
            index = 0;
        }


        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            Iterator.super.forEachRemaining(action);
        }

        @Override
        public boolean hasNext() {
            return (list.size()>index+1);
        }

        @Override
        public Object next() {
            if(hasNext()) return list.get(index++);
            else return null;
        }
    }

}
