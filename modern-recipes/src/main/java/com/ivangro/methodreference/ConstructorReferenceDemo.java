package com.ivangro.methodreference;

import com.ivangro.methodreference.dto.Person;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorReferenceDemo {

  public static void main(String[] args) {

    List<String> names = Arrays.asList("Mary", "Pep", "John");

    List<Person> people = names.stream().map(Person::new).collect(Collectors.toList());

    // Person::new is a copy constructor to isolate streaming code from the original instances
    Person personBefore = new Person("Ada Lovelace");
    List<Person> peopleAfter = Stream.of(personBefore).map(Person::new)
        .collect(Collectors.toList());
    // assertFalse(personBefore == peopleAfter.get(0))
    // assertEquals(personBefore, peopleAfter.get(0))

    // Person::new is a varargs constructor
    List<String> namesCompound = Arrays.asList("St Mary", "John Dereck");
    namesCompound.stream().map(name -> name.split(" ")).map(Person::new)
        .collect(Collectors.toList());

  }
}
