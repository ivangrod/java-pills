package com.ivangro.interfaces;

/* Benefits fot this annotation
 * 1. Trigger a compile-time check that the interface does satisfy the requirement
 * 2. It generates a statement in the Javadocs
 */
@FunctionalInterface
public interface PalindromeChecker {

  // A single abstract method (SAM). Implicit public and abstract keyword.
  boolean isPalindrome(String word);

  // Functional interface can have default methods
  default String aDefaultMethod() {
    return "This is a default method into the functional interface";
  }

  // Functional interface can have static methods
  static void aStaticMethod() {
    System.out.println("This is a static method into the functional interface");
  }
}
