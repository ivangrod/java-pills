package com.ivangro.methodreference.dto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Person {

  private final String name;

  public Person(String name) {
    this.name = name;
  }

  public Person(Person personBefore) {
    this.name = personBefore.getName();
  }

  public Person(String... names) {
    this.name = Arrays.stream(names).collect(Collectors.joining(" "));

  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + '}';
  }
}
