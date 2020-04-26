package com.ivangro.lambda;

public class RunnableDemo {

  public static void main(String[] args) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Inside runnable using an anonymous inner class");
      }
    }).start();

    new Thread(() -> System.out.println("Inside runnable using a lambda")).start();

    // Declarative vs Imperative
    // Lambda expressions can only be assigned to functional interface references
    Runnable runnable = () -> System.out
        .println("Inside runnable using a lambda assigned into a variable");
    new Thread(runnable).start();

  }
}
