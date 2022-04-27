package Seven;

public class SevenFive {


}

/*
public class DeepIterator implements Iterator<String> {

                                        //объявление полей

    private Stack<Iterator> iterators;  //стек итераторов
    private String next;                //поле строка "следующее"
    private boolean hasNext;            //есть ли следующее


                                         // конструктор дипитератора через первый итератор

    public DeepIterator(Iterator<?> iterator) {
        this.iterators = new Stack<Iterator>();     //объявление стека
        iterators.push(iterator);                   //первый элемент стека

        updateNext();                               //обновление следующего
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    private void updateNext(){

        if(iterators.empty()){                      // если стек итераторов пустой, то следующий - пусто, есть следующий - пусто, конец метода
            next = null;
            hasNext = false;
            return;
        }

        Iterator current = iterators.peek();        // берем последний элемент стека

        if (current.hasNext()) {                    // если у последнего элемента есть "следующий"
            Object o = current.next();              // объект = следующий за последним
            if (o instanceof String) {              // если объект это строка
                next = (String) o;                  // "следующий" = строка
                hasNext = true;                     // наличие следующего - да
            } else if (o instanceof Iterator) {     // если следующий это итератор
                Iterator iterator = (Iterator) o;   // объявление следующего итератором
                iterators.push(iterator);           // берем итератор и пихаем его в стек
                updateNext();                       // обновляем "следующий"
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            iterators.pop();                        // убираем крайний элемент из стека
            updateNext();                           // обновляем "следующий"
        }
    }

    @Override
    public String next() throws NoSuchElementException {

        if(!hasNext){                               // если следующего нет - нет элемента
            throw new NoSuchElementException();
        }

        String nextToReturn = next;                 // строка = "следующий"
        updateNext();                               // обновить "следующий"
        return nextToReturn;                        // возврат этой строки
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
 */