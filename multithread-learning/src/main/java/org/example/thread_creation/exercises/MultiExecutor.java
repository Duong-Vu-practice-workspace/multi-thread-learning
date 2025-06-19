package org.example.thread_creation.exercises;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor extends Thread{
    private final List<Runnable> tasks;
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }
    public void executeAll() {
        List<Thread> threads = new ArrayList<>(tasks.size());
        for (Runnable runnable : tasks) {
            threads.add(new Thread(runnable));
        }
        for (Thread x : threads) {
            x.start();
        }
    }

}
