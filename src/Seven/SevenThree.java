package Seven;

import java.util.Iterator;
import java.util.function.Consumer;

public class SevenThree {

    public static void main(String[] args) {
        Integer[][] array ={{1,4,7,89}, {2,5,7,8}};
        MyDoubleIter<Integer> iterator = new MyDoubleIter<>(array);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



}

class MyDoubleIter<T> implements Iterator<T>{

    private T[][] array;
    int indexI;
    int indexJ;

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }

    private boolean setNextIndexes(){
        if (hasNext()){
            if (indexJ == array[0].length - 1){
                indexJ = 0;
                indexI ++;
            } else indexJ++;
            return true;
        }
        return false;
    }


    @Override
    public T next() {

        if (setNextIndexes());
        return array[indexI][indexJ];

    }




    public MyDoubleIter(T[][] array){
        this.array = array;
        indexI = 0;
        indexJ = -1;
    }

    @Override
    public boolean hasNext(){
        if (indexI == array.length-1 && indexJ == array[0].length-1) return false;
        else return (indexI < array.length && indexJ < array[0].length);
    }


}
