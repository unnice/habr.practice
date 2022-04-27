package MyStream;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WithPerson {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person( 18, "Peter"),
                new Person( 23, "Julia"),
                new Person( 23, "Jang"),
                new Person( 23, "James"),
                new Person( 12, "Mila"));

        List<Person> filtered = persons
                .stream()
                .filter(p -> p.name.startsWith("J"))
                .collect(Collectors.toList());

        System.out.println(filtered);

        Map<Integer, List<Person>> personByAge = persons.stream()
                .collect(Collectors.groupingBy(p -> p.age));

        System.out.println(personByAge);

        Map<Integer, String> map = persons.stream()
                .collect(Collectors.toMap(
                        p -> {return p.age;},
                        p -> {return p.name;},
                        (String name1, String name2) -> {return name1 + ", " + name2;}
                ));
        System.out.println(map);

        HashMap hmap = new HashMap<>();




    }

public record Dog(String name, int tailLenght, String color){}
    

}

class Person{

    String name;
    int age;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }



}
