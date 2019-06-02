package org.ivangrod.javapills.exceptions;

import javax.swing.plaf.synth.SynthParser;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Logger;

public class HandlingExceptionPractices {

    public Employee getEmployee(int i) {

        Employee[] employeeArray = {new Employee("David"), new Employee("Rhett"), new
                Employee("Scott")};

        if (i >= employeeArray.length) {
            System.out.println("Index is too high!");
            return null;
        } else {
            System.out.println("Employee found: " + employeeArray[i].name);
            return employeeArray[i];
        }
    }

    /**
     * This method substitute to a block like this:
     * <pre>
     * BufferedReader br = new BufferedReader(new FileReader(path));
     * try {
     *  return br.readLine();
     * } finally {
     *  if(br != null) br.close();
     * }
     * </pre>
     */
    public static String readFirstLineFromFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }

        // This way, you don't have to concern yourself with closing the resources yourself, as the
        // try-with-resources block ensures that the resources will be closed upon the end of the statement.
    }

    public String readFirstLine(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }

    public void parseFile(String filePath) {
        try {
            // some code that forms an exception
        } catch (Exception ex) {
        }

        try {
            // some code that forms an exception
        } catch (Exception ex) {
            /*
             * This approach forms an illusion of handling. Yes, while it is better than simply ignoring
             * the exception, by printing out the relevant information, this doesn't handle the exceptional
             * condition any more than ignoring it does.
             */
            ex.printStackTrace();
        }
    }

    public String doSomething() {
        String name = "David";
        try {
            throw new IOException();
        } finally {
            return name;
        }
    }

    public static String doSomethingMore() {
        try {
            // some code that forms an exception
        } catch (IllegalArgumentException ia) {
            throw ia;
        } finally {
            throw new RuntimeException();
        }
    }

    public static String readFirstLineLogTrace(String url) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File(url));
            return scanner.nextLine();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex);
            throw ex;
        }
    }

    private class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }
    }
}
