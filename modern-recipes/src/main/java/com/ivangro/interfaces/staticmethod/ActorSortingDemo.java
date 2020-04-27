package com.ivangro.interfaces.staticmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ActorSortingDemo {

  public static void main(String[] args) {

    List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig");

    // Static method must be an implementation
    // You cannot override a static method
    List<String> bondsSorted = bonds.stream().sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());

    // Call static methods from the interface name
    bondsSorted = bonds.stream().sorted(Comparator.comparing(String::length))
        .collect(Collectors.toList());

    // You dont need to implement an interface to use its static methods
    bonds.stream()
        .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
        .collect(
            Collectors.toList());
  }
}
