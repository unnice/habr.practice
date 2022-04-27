package firstPackage;

import java.util.*;

public class CollectionExersises {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Yellow");
        list.add("Green");
        list.add("Blue");
        list.add("Orange");
        list.add("Grey");
        list.add(0, "White");
        list.set(2, "Renew!");
        list.remove(1);
        int index = list.indexOf("Grey");
        index = list.indexOf("nothing");
        Collections.sort(list);

        ArrayList listB = new ArrayList();
        listB.add("A");
        listB.add("B");
        listB.add("C");
        listB.add("D");
        listB.add("E");

        Collections.shuffle(list);
        Collections.reverse(listB);
        //listB = list.subList(0, 3);

        Collections.swap(listB, 1, 2);




        Collections.copy(listB, list);
        Collections.addAll(listB, list);
        Iterator it = list.iterator();


        ArrayList listC = (ArrayList) list.clone();

        listB.trimToSize();
        listB.ensureCapacity(15);






        for (String str: list
             ) {
            System.out.println(str);
        }
    }



}
