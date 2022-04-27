package MyStream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStream {

    public static void main(String[] args) {

        Arrays.asList("one", "two", "three")
                .stream()
                .findFirst()
                .ifPresent((s)-> System.out.println(s));

        IntStream stream = IntStream.range(1, 25);
        System.out.println(stream.sum());
        stream.average().ifPresent(a -> System.out.println(a));







    }



}
