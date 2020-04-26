package com.ivangro.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerDemo {

  public static void main(String[] args) {

    Stream.of(1, 2, 3, 4, 5).forEach(digit -> System.out.println(digit));

    // Using a method reference
    // The double-colon notation provides the reference to the 'println' method on the 'System.out'
    // instance
    Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

    // Assigning the method reference to a functional interface
    Consumer<Integer> printer = System.out::println;
    Stream.of(1, 2, 3, 4, 5).forEach(printer);

    // Using a method reference to a static method versus instance method
    Stream.generate(Math::random).limit(10).forEach(System.out::println);

    List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
    strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());

    // The first element supplier by the context (a pair of strings) becomes the target and the
    // remaining elements are arguments to the method
    strings.stream().sorted(String::compareTo).collect(Collectors.toList());
  }
}
