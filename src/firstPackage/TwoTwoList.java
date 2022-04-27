package firstPackage;

import java.util.*;

public class TwoTwoList<E> implements java.util.List {

    private int size;
    private Entry<E> first;
    private Entry<E> last;



    public TwoTwoList(){
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (last == null) return true;
        else return false;
    }

    @Override
    public boolean contains(Object o) {
        if(indexOf(o) >=0) return true;
        return false;
    }

    @Override
    public Iterator iterator() {
        return new TwoTwoIterator(0);
    }



    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++){
            array[i] = get(i);
        }
        return array;
    }



    @Override
    public boolean add(Object o) {
        if (isEmpty()){
            Entry<E> newEntry = new Entry(o, null, null);
            last = newEntry;
            first = newEntry;
            newEntry.next = null;
            newEntry.prev = null;
        }else {
            Entry<E> newEntry = new Entry(o, last, null);
            Entry<E> prelast = last;
            last = newEntry;
            prelast.next = newEntry;
        }
        size++;
        return true;
        }



    @Override
    public boolean remove(Object o) {
        Entry ent = first;
        if (o == null){
            while (ent != null){ent = ent.next;}
        }
        if (o != null){
            while (!ent.element.equals(o)){ent = ent.next;}
        }
        deleteEntry(ent);
        return true;
    }

    private void deleteEntry(Entry e){

        if (e.next == null) {
            last = e.prev;
        }
        else if (e.prev == null) first = e.next;
        else {
            e.prev.next = e.next;
            e.next.prev = e.prev;
        }

        size--;

    }

    @Override
    public boolean addAll(Collection c) {
        add(size-1, c);
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {

        if(!c.isEmpty()){
            Object[] array = c.toArray();
            for (int i = 0; i < array.length; i++){
                add(index+i, array[i]);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (Entry<E> entr = first; entr != null;){
            Entry next = entr.next;
            entr.next = null;
            entr.prev = null;
            entr.element = null;
            entr = next;
        }
        last = null;
        first = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        Entry<E> entr = getEntryAtIndex(index);
        return  entr.element;
    }

    @Override
    public E set(int index, Object element) {
        Entry<E> entr = getEntryAtIndex(index);
        E old = entr.element;
        entr.element = (E) element;
        return old;
    }

    @Override
    public void add(int index, Object element) {
        Entry next = getEntryAtIndex(index);
        if (next!=null){
            Entry newEntr = new Entry(element, next.prev, next);
            next.prev = newEntr;
            newEntr.prev.next = newEntr;
            size++;
        } else if (isEmpty()){
            Entry newEntr = new Entry(element, null, null);
            first = newEntr;
            last = newEntr;
            size++;
        } //write exception


    }

    @Override
    public Object remove(int index) {
        Entry<E> entr = getEntryAtIndex(index);
        deleteEntry(entr);
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Entry ent = first;

        if (o == null) {
            while (ent != null) {
                if (ent.element == null) {
                    return index;
                }
                index++;
                ent = ent.next;
            }
        }
        if (o != null) {
            while (ent != null) {
                if (ent.element == o) {
                    return index;
                }
                index++;
                ent = ent.next;
            }

        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private static class Entry<T>{
        private T element;
        protected Entry prev;
        protected Entry next;

        public Entry(T element, Entry prev, Entry next){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public void setPrev(Entry prev) {
            this.prev = prev;
        }

        public Object getElement() {
            return element;
        }

        public Entry getNext() {
            return next;
        }

        public Entry getPrev() {
            return prev;
        }
    }

    private Entry<E> getEntryAtIndex(int index){
        if(!isEmpty() && index<=size){
            int ind = 0;
            Entry ent = first;
            while (ind != index){
                ind++;
                ent = ent.next;
            }
            return ent;
        } else return null;

    }

    public class TwoTwoIterator implements Iterator{

        private Entry<E> currentEntry;
        private Entry<E> lastEntry;
        private int index;

        public TwoTwoIterator(int index){
            this.currentEntry = getEntryAtIndex(index);
            this.index = index;
        }




        @Override
        public boolean hasNext() {
            if(currentEntry.next == null) return false;
            else return true;
        }

        @Override
        public E next() {
            lastEntry = currentEntry;
            currentEntry = currentEntry.next;
            index++;
            return lastEntry.element;

        }
    }
}


