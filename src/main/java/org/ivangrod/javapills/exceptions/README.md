# Exception Handling

## Exception Hierarchy

Exceptions are, after all, simply Java objects that extend the **Throwable** interface:

```
                    ---> Throwable <--- 
                   |     (checked)    |
                   |                  |
                   |                  |
           ---> Exception           Error
           |    (checked)        (unchecked)
           |
    RuntimeException
       (unchecked)
```

* **Checked Exceptions**: Exceptions that the Java Compiler requires us to either handle-or-declare when writing code. The handle-or-declare rule refers to our responsibility to either declare that a method throws an exception up the call stack
* **Unchecked Exceptions / Runtime Exceptions**: Unchecked Exceptions are the exceptions that typically occur due to human, rather than an environmental error. These exceptions are not checked during compile-time, but at runtime.
* **Errors**: Errors are the most serious exceptional conditions that you can run into. They are often irrecoverable from and there's no real way to handle them: StackOverflowError, OutOfMemoryError, ...

## Best Exception Handling Practices

### Avoid Exceptional Conditions

Sometimes, by using simple checks, we can avoid an exception forming altogether:

(link)

Calling this method with an index that's out of bounds would result in a null value. In any case, even though the index is too high, the offending line of code will not execute and no exception will arise.

### Use try-with-resources

(link)

### Close resources in try-catch-finally (previous Java 7)

If you're not utilizing the previous advice for any reason, at least make sure to close the resources manually in the **finally** block:

(link)

The finally block executes regardless of what happens in the try block. Even if it ends abruptly by throwing an exception, the finally block will execute.

This was often used to close the resources that were opened in the try block since an arising exception would skip the code closing them.

## **WORST** Exception Handling Practices

### Swallowing Exceptions (X)

If your intention is to simply satisfy the compiler, you can easily do so by swallowing the exception:

(link)

Swallowing an exception refers to the act of catching an exception and not fixing the issue.

### Return in a finally Block (X)

In essence, by abruptly returning from a **finally** block, the JVM will drop the exception from the try block and all valuable data from it will be lost:

(link)

In this case, even though the try block throws a new IOException, we use return in the finally block, ending it abruptly. This causes the try block to end abruptly due to the return statement, and not the IOException, essentially dropping the exception in the process.

### Throwing in a finally Block (X)

Using throw in a finally block will drop the exception from the try-catch block:

(link)

### Logging and Throwing (X)

Doing this is redundant and will simply result in a bunch of log messages which aren't really needed. The amount of text will reduce the visibility of the logs:

(link)

Doing this is redundant and will simply result in a bunch of log messages which aren't really needed. The amount of text will reduce the visibility of the logs.

### Catching Exception or Throwable

Catching **Exception** will catch both checked and runtime exceptions. Runtime exceptions represent problems that are a direct result of a programming problem, and as such shouldn't be caught since it can't be reasonably expected to recover from them or handle them.

Catching **Throwable** will catch everything. This includes all errors, which aren't actually meant to be caught in any way.