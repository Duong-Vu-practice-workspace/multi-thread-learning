package org.example.thread_creation.thread_inheritance;

public class Main {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }
    public static class NewThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello from " + this.getName());
        }
    }
}
