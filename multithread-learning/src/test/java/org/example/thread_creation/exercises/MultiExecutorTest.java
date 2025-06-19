package org.example.thread_creation.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class MultiExecutorTest {

    @Test
    public void testExercise() throws InterruptedException {
        String string1 = "Cutting carrots";
        String string2 = "Cooking eggs";
        String string3 = "Washing dishes";

        Runnable task1 = () -> System.out.println(string1);
        Runnable task2 = () -> System.out.println(string2);
        Runnable task3 = () -> System.out.println(string3);

        List<Runnable> tasks = Arrays.asList(task1, task2, task3);

        MultiExecutor multiExecutor = new MultiExecutor(tasks);

        // Redirect System.out to capture output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        multiExecutor.executeAll();

        Thread.sleep(1000); // Wait for threads to finish

        System.setOut(originalOut); // Restore original System.out

        String output = baos.toString();

        Assertions.assertTrue(output.contains(string1), "The task " + string1 + " is not executed");
        Assertions.assertTrue(output.contains(string2), "The task " + string2 + " is not executed");
        Assertions.assertTrue(output.contains(string3), "The task " + string3 + " is not executed");
    }
}